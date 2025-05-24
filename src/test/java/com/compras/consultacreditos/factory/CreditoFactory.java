package com.compras.consultacreditos.factory;

import com.compras.consultacreditos.entity.Credito;
import com.compras.consultacreditos.model.response.CreditoResponse;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreditoFactory {
    public static Credito criarNotaFiscal() {
        return Credito.builder()
                .id(1L)
                .numeroCredito("123456")
                .numeroNfse("7891011")
                .dataConstituicao(LocalDate.of(2024, 6, 1))
                .valorIssqn(new BigDecimal("1500.75"))
                .tipoCredito("ISSQN")
                .simplesNacional(true)
                .aliquota(new BigDecimal("5.00"))
                .valorFaturado(new BigDecimal("30000.00"))
                .valorDeducao(new BigDecimal("5000.00"))
                .baseCalculo(new BigDecimal("25000.00"))
                .build();
    }

    public static CreditoResponse criarNotaFiscalResponse() {
        return CreditoResponse.builder()
                .numeroCredito("123456")
                .numeroNfse("7891011")
                .dataConstituicao(LocalDate.of(2024, 6, 1))
                .valorIssqn(new BigDecimal("1500.75"))
                .tipoCredito("ISSQN")
                .simplesNacional(true)
                .aliquota(new BigDecimal("5.00"))
                .valorFaturado(new BigDecimal("30000.00"))
                .valorDeducao(new BigDecimal("5000.00"))
                .baseCalculo(new BigDecimal("25000.00"))
                .build();
    }

    public static String numeroNfse() {
        return "7891011";
    }

    public static String numeroCredito() {
        return "789012";
    }
}