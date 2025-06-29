package com.tc3wellness.Sistema.entity;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class Especialidade {
    private UUID id;
    private String nome;
    private String descricao;
}
