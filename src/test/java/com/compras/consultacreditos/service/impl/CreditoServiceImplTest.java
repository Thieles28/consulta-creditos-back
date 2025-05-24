package com.compras.consultacreditos.service.impl;

import com.compras.consultacreditos.entity.Credito;
import com.compras.consultacreditos.factory.CreditoFactory;
import com.compras.consultacreditos.model.response.CreditoResponse;
import com.compras.consultacreditos.repository.CreditoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreditoServiceImplTest {
    @InjectMocks
    private CreditoServiceImpl creditoService;

    @Mock
    private CreditoRepository creditoRepository;

    @Mock
    private ModelMapper modelMapper;

    private Credito credito;
    private CreditoResponse creditoResponse;
    private String numeroNfse;
    private String numeroCredito;

    @BeforeEach
    void setUp() {
        credito = CreditoFactory.criarNotaFiscal();
        creditoResponse = CreditoFactory.criarNotaFiscalResponse();
        numeroNfse = CreditoFactory.numeroNfse();
        numeroCredito = CreditoFactory.numeroCredito();
    }

    @Test
    void listarCreditos() {
        var creditos = List.of(credito);
        when(creditoRepository.findByNumeroNfseIgnoreCase(numeroNfse)).thenReturn(creditos);
        when(modelMapper.map(credito, CreditoResponse.class)).thenReturn(creditoResponse);

        var response = creditoService.listarCreditos(numeroNfse);

        assertEquals(1, response.size());
        assertEquals(credito.getNumeroNfse(), response.getFirst().getNumeroNfse());
        assertEquals(credito.getNumeroCredito(), response.getFirst().getNumeroCredito());
        assertEquals(credito.getDataConstituicao(), response.getFirst().getDataConstituicao());
    }

    @Test
    void consultarCredito() {
        when(creditoRepository.findByNumeroCreditoIgnoreCase(numeroCredito)).thenReturn(Optional.of(credito));
        when(modelMapper.map(credito, CreditoResponse.class)).thenReturn(creditoResponse);

        var response = creditoService.consultarCredito(numeroCredito);

        assertEquals(credito.getNumeroCredito(), response.getNumeroCredito());
        assertEquals(credito.getNumeroCredito(), response.getNumeroCredito());
        assertEquals(credito.getDataConstituicao(), response.getDataConstituicao());
    }
}