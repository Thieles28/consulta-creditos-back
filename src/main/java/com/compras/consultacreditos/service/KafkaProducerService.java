package com.compras.consultacreditos.service;

public interface KafkaProducerService {
    void publishConsultaCredito(String topico, String mensagem);
}
