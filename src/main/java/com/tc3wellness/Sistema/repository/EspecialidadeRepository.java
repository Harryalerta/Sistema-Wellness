package com.tc3wellness.Sistema.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.tc3wellness.Sistema.entity.Especialidade;
import com.tc3wellness.Sistema.repository.JpaRepository.EspecialidadeJpaRepository;
import com.tc3wellness.Sistema.repository.JpaRepository.tableEntities.EspecialidadeTableEntity;

@Component
public class EspecialidadeRepository {
    
    public EspecialidadeRepository(EspecialidadeJpaRepository repository) {
        this.repository = repository;
    }

    private final EspecialidadeJpaRepository repository;

    public Especialidade cadastrar(Especialidade especialidade) {
        
        EspecialidadeTableEntity especialidadeTable = new EspecialidadeTableEntity (especialidade);
        especialidadeTable.setId(UUID.randomUUID());
        especialidadeTable = repository.save(especialidadeTable);

        return especialidadeTable.toEspecialidadeEntidade();
    }

    public Especialidade buscaPorId(UUID idEspecialidade) {

        return repository.findById(idEspecialidade).get().toEspecialidadeEntidade();
    }
    
}
