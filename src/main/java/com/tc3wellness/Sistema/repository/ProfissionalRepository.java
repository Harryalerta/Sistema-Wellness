package com.tc3wellness.Sistema.repository;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.tc3wellness.Sistema.entity.Profissional;
import com.tc3wellness.Sistema.repository.JpaRepository.ProfissionalJpaRepository;
import com.tc3wellness.Sistema.repository.JpaRepository.tableEntities.EspecialidadeTableEntity;
import com.tc3wellness.Sistema.repository.JpaRepository.tableEntities.ProfissionalTableEntity;

@Component
public class ProfissionalRepository {

    private final ProfissionalJpaRepository repository;

    public ProfissionalRepository(ProfissionalJpaRepository repository) {
        this.repository = repository;
    }

    public Profissional cadastrar(Profissional profissional) {

        ProfissionalTableEntity profissionalTable = new ProfissionalTableEntity(profissional);
        profissionalTable.setId(UUID.randomUUID());
        profissionalTable.setEspecialidades(Set.of());

        return repository.save(profissionalTable).toProfissionalEntidade();
    }

    public Profissional buscaPorId(UUID id) {
        return repository.findById(id).get().toProfissionalEntidade();
    }

    public Profissional salvar(Profissional profissional) {
        ProfissionalTableEntity profissionaTable = new ProfissionalTableEntity(profissional);

        Set<EspecialidadeTableEntity> especialidadesTable = new HashSet<>();
        profissional.getEspecialidades()
                .forEach(especialidade -> especialidadesTable.add(new EspecialidadeTableEntity(especialidade)));
        profissionaTable.setEspecialidades(especialidadesTable);

        return repository.save(profissionaTable).toProfissionalEntidade();
    }

}
