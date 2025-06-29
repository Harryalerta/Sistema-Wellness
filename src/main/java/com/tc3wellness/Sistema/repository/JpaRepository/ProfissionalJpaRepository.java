package com.tc3wellness.Sistema.repository.JpaRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.tc3wellness.Sistema.repository.JpaRepository.tableEntities.ProfissionalTableEntity;

@Component
public interface ProfissionalJpaRepository extends JpaRepository<ProfissionalTableEntity, UUID> {

}
