package com.tc3wellness.Sistema.repository.JpaRepository.tableEntities;

import java.util.Set;
import java.util.UUID;

import com.tc3wellness.Sistema.entity.Especialidade;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ESPECIALIDADE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadeTableEntity {
    @Id
    private UUID id;
    private String nome;
    private String descricao;
    @ManyToMany(mappedBy = "especialidades")
    private Set<ProfissionalTableEntity> profissionais;

    public EspecialidadeTableEntity(Especialidade especialidade) {
        this.id = especialidade.getId();
        this.nome = especialidade.getNome();
        this.descricao = especialidade.getDescricao();
    }

    public Especialidade toEspecialidadeEntidade() {
        return new Especialidade(id, nome, descricao);
    }
}
