package com.tc3wellness.Sistema.entity;

import java.util.Set;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Estabelecimento {
    private UUID id;
    private String nome;
    private String endereco;
    private Set<Profissional> profissionais;
    private HorarioAtendimento horarioAtendimento;
}
