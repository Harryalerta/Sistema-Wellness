package com.tc3wellness.Sistema.data;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class VincularEstabelecimentoRequisicao {

    private UUID idEstabelecimento;
    private List<UUID> listaProfissionais;
}
