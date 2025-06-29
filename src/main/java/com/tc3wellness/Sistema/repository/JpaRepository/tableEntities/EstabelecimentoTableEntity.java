package com.tc3wellness.Sistema.repository.JpaRepository.tableEntities;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.tc3wellness.Sistema.entity.Estabelecimento;
import com.tc3wellness.Sistema.entity.HorarioAtendimento;
import com.tc3wellness.Sistema.entity.Profissional;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ESTABELECIMENTO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstabelecimentoTableEntity {
    @Id
    private UUID id;
    private String nome;
    private String endereco;
    private LocalTime horarioAbertura;
    private LocalTime horarioFechamento;
    @OneToMany
    @JoinTable(name = "ESTABELECIMENTO_PROFISSIONAL", joinColumns = @JoinColumn(name = "estabelecimento_id"), inverseJoinColumns = @JoinColumn(name = "profissional_id"))
    private Set<ProfissionalTableEntity> profissionais;

    public EstabelecimentoTableEntity(Estabelecimento estabelecimento) {
        this.id = estabelecimento.getId();
        this.nome = estabelecimento.getNome();
        this.endereco = estabelecimento.getEndereco();
        this.horarioAbertura = estabelecimento.getHorarioAtendimento().getAbertura();
        this.horarioFechamento = estabelecimento.getHorarioAtendimento().getFechamento();
        Set<ProfissionalTableEntity> profissionaisTable = new HashSet<>();
        estabelecimento.getProfissionais()
                .forEach(profissional -> profissionaisTable.add(new ProfissionalTableEntity(profissional)));
        this.profissionais = profissionaisTable;
    }

    public Estabelecimento toEstabelecimento() {
        Set<Profissional> profissionaisEntity = new HashSet<>();
        this.profissionais.forEach(profissional -> profissionaisEntity.add(profissional.toProfissionalEntidade()));
        HorarioAtendimento horario = new HorarioAtendimento(this.horarioAbertura, this.horarioFechamento);
        return new Estabelecimento(this.id, this.nome, this.endereco, profissionaisEntity, horario);
    }

}
