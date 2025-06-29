package com.tc3wellness.Sistema.usecase;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.tc3wellness.Sistema.entity.Estabelecimento;
import com.tc3wellness.Sistema.entity.Profissional;
import com.tc3wellness.Sistema.repository.EstabelecimentoRepository;
import com.tc3wellness.Sistema.repository.ProfissionalRepository;

@Component
public class ConsultaUsecase {

    private final EstabelecimentoRepository estabelecimentoRepository;
    private final ProfissionalRepository profissionalRepository;

    public ConsultaUsecase(EstabelecimentoRepository estabelecimentoRepository,
            ProfissionalRepository profissionalRepository) {
        this.estabelecimentoRepository = estabelecimentoRepository;
        this.profissionalRepository = profissionalRepository;
    }

    public Estabelecimento consultaEstabelecimentoPorId(String estabelecimentoId) {
        try {
            return estabelecimentoRepository.buscaPorId(converteUUID(estabelecimentoId));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Estabelecimento não encontrado", e);
        }
    }

    public Profissional consultaProfissionalPorId(String id_profissional) {
        try {
            return profissionalRepository.buscaPorId(converteUUID(id_profissional));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Estabelecimento não encontrado", e);
        }

    }

    private UUID converteUUID(String estabelecimentoId) {
        try {
            return UUID.fromString(estabelecimentoId);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("ID Informada não é válida", e);
        }
    }

}
