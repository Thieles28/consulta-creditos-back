package com.compras.consultacreditos.service.impl;

import com.compras.consultacreditos.model.response.CreditoResponse;
import com.compras.consultacreditos.repository.CreditoRepository;
import com.compras.consultacreditos.service.CreditoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.compras.consultacreditos.util.Mensagens.NUMERO_CREDITO_NAO_ENCONTRADO;

@Service
@RequiredArgsConstructor
public class CreditoServiceImpl implements CreditoService {


    private final CreditoRepository creditoRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CreditoResponse> listarCreditos(String numeroNfse) {
        return creditoRepository.findByNumeroNfseIgnoreCase(numeroNfse).stream()
                .map(credito -> modelMapper.map(credito, CreditoResponse.class))
                .toList();
    }

    @Override
    public CreditoResponse consultarCredito(String numeroCredito) {
        return creditoRepository.findByNumeroCreditoIgnoreCase(numeroCredito)
                .map(credito -> modelMapper.map(credito, CreditoResponse.class))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, NUMERO_CREDITO_NAO_ENCONTRADO));
    }
}