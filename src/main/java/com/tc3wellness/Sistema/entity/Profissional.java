package com.tc3wellness.Sistema.entity;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profissional {

    private UUID id;
    private String nome;
    private List<Especialidade> especialidades;
    private HorarioAtendimento horario;
    private ValorAtendimento valor;

    public Profissional(String nome, List<Especialidade> especialidades, HorarioAtendimento horario,
            ValorAtendimento valor) {
        this.id = UUID.randomUUID();
        this.especialidades = especialidades;
        this.nome = nome;
        this.horario = horario;
        this.valor = valor;
    }
}
