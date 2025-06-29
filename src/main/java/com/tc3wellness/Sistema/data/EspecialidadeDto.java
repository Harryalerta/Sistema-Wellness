/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.tc3wellness.Sistema.data;

import com.tc3wellness.Sistema.entity.Especialidade;

import lombok.Data;

@Data
class EspecialidadeDto {
    private String nome;
    private String descricao;

    /**
     * 
     */
    public EspecialidadeDto(Especialidade especialidade) {
        this.nome = especialidade.getNome();
        this.descricao = especialidade.getDescricao();
    }

}
