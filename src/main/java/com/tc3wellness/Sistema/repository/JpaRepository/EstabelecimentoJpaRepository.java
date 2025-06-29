package com.tc3wellness.Sistema.repository.JpaRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tc3wellness.Sistema.repository.JpaRepository.tableEntities.EstabelecimentoTableEntity;

public interface EstabelecimentoJpaRepository extends JpaRepository<EstabelecimentoTableEntity, UUID> {

}
