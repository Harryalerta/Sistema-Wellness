package com.tc3wellness.Sistema.data;

import lombok.Data;

@Data
public class CadastrarEstabelecimentoRequisicao {
    private String nome;
    private String endereco;
    private String HorarioAbertura;
    private String HorarioFechamento;
}
