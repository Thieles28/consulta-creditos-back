package com.compras.consultacreditos.service;

import com.compras.consultacreditos.model.response.CreditoResponse;

import java.util.List;

public interface CreditoService {
    List<CreditoResponse> listarCreditos(String numeroNfse);

    CreditoResponse consultarCredito(String id);
}
