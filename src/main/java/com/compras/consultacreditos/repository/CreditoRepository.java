package com.compras.consultacreditos.repository;

import com.compras.consultacreditos.entity.Credito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CreditoRepository extends JpaRepository<Credito, Long> {
    List<Credito> findByNumeroNfseIgnoreCase(String numeroNfse);

    Optional<Credito> findByNumeroCreditoIgnoreCase(String numeroCredito);
}
