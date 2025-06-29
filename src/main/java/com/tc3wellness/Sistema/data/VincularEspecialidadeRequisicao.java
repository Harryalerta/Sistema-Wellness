package com.tc3wellness.Sistema.data;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class VincularEspecialidadeRequisicao {

    private UUID idProfissional;
    private List<UUID> listaEspecialidades;
}
