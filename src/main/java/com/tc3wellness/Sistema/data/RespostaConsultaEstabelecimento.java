
package com.tc3wellness.Sistema.data;

import com.tc3wellness.Sistema.entity.Estabelecimento;

import lombok.Data;

@Data
public class RespostaConsultaEstabelecimento {
    private String nome;
    private String horarioAbertura;
    private String horarioFechamento;
    private String endereco; 

    public RespostaConsultaEstabelecimento(Estabelecimento estabelecimento) {
        this.nome = estabelecimento.getNome();
        this.horarioAbertura = estabelecimento.getHorarioAtendimento().getAbertura().toString();
        this.horarioFechamento = estabelecimento.getHorarioAtendimento().getFechamento().toString();
        this.endereco = estabelecimento.getEndereco();
    }

}
