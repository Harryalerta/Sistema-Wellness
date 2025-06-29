package com.tc3wellness.Sistema.repository;

import java.util.HashSet;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.tc3wellness.Sistema.entity.Estabelecimento;
import com.tc3wellness.Sistema.repository.JpaRepository.EstabelecimentoJpaRepository;
import com.tc3wellness.Sistema.repository.JpaRepository.tableEntities.EstabelecimentoTableEntity;

@Component
public class EstabelecimentoRepository {

    private final EstabelecimentoJpaRepository repository;

    /**
     * @param repository
     */
    public EstabelecimentoRepository(EstabelecimentoJpaRepository repository) {
        this.repository = repository;
    }

    public Estabelecimento cadastrar(Estabelecimento estabelecimento) {
        EstabelecimentoTableEntity estabelecimentoTable = new EstabelecimentoTableEntity(estabelecimento);
        estabelecimentoTable.setId(UUID.randomUUID());
        estabelecimentoTable.setProfissionais(new HashSet<>());

        return repository.save(estabelecimentoTable).toEstabelecimento();
    }

    public Estabelecimento buscaPorId(UUID idEstabelecimento) {
        return repository.findById(idEstabelecimento).orElseThrow().toEstabelecimento();
    }

    public Estabelecimento salvar(Estabelecimento estabelecimento) {
        EstabelecimentoTableEntity estabelecimentoTable = new EstabelecimentoTableEntity(estabelecimento);
        return repository.save(estabelecimentoTable).toEstabelecimento();
    }

}
