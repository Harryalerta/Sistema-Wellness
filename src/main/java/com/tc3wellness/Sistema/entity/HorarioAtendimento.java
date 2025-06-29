package com.tc3wellness.Sistema.entity;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class HorarioAtendimento {
    private LocalTime abertura;
    private LocalTime fechamento;
}
