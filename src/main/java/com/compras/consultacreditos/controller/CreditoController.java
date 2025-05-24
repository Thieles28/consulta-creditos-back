package com.compras.consultacreditos.controller;

import com.compras.consultacreditos.model.response.CreditoResponse;
import com.compras.consultacreditos.service.CreditoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("creditos")
@RequiredArgsConstructor
public class CreditoController {

    private final CreditoService creditoService;

    @GetMapping(value = "{numeroNfse}")
    @Operation(summary = "Listar Nota Fiscal")
    @ApiResponse(responseCode = "200", description = "Listar Nota Fiscal",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreditoResponse.class)))
    public ResponseEntity<List<CreditoResponse>> listarCreditos(@PathVariable("numeroNfse") String numeroNfse) {
        return ResponseEntity.status(HttpStatus.OK).body(creditoService.listarCreditos(numeroNfse));
    }

    @GetMapping(value = "credito/{numeroCredito}")
    @Operation(summary = "Consultar Nota Fiscal")
    @ApiResponse(responseCode = "200", description = "Consultar Nota Fiscal",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreditoResponse.class)))
    public ResponseEntity<CreditoResponse> consultarCredito(@PathVariable("numeroCredito") String numeroCredito) {
        return ResponseEntity.status(HttpStatus.OK).body(creditoService.consultarCredito(numeroCredito));
    }
}