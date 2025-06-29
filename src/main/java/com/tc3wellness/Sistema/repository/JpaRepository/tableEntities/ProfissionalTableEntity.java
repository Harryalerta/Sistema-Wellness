package com.tc3wellness.Sistema.repository.JpaRepository.tableEntities;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.tc3wellness.Sistema.entity.Especialidade;
import com.tc3wellness.Sistema.entity.HorarioAtendimento;
import com.tc3wellness.Sistema.entity.Profissional;
import com.tc3wellness.Sistema.entity.ValorAtendimento;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PROFISSIONAL")
@Getter
@Setter
@NoArgsConstructor
public class ProfissionalTableEntity {
    @Id
    private UUID id;
    private String nome;
    private LocalTime horarioInicio;
    private LocalTime horarioFechamento;
    private int valor;
    @ManyToMany
    @JoinTable(name = "ESPECIALIDADE_PROFISSIONAL", joinColumns = @JoinColumn(name = "profissional_id"), inverseJoinColumns = @JoinColumn(name = "especialidade_id"))
    private Set<EspecialidadeTableEntity> especialidades;

    public Profissional toProfissionalEntidade() {
        ValorAtendimento valorEntidade = new ValorAtendimento(valor);
        HorarioAtendimento horarioEntidade = new HorarioAtendimento(horarioInicio, horarioFechamento);
        List<Especialidade> especialidadesEntidade = new LinkedList<>();

        especialidades.forEach(especialidade -> especialidadesEntidade.add(especialidade.toEspecialidadeEntidade()));

        return Profissional.builder().id(id).nome(nome).valor(valorEntidade).horario(horarioEntidade)
                .especialidades(especialidadesEntidade).build();
    }

    public ProfissionalTableEntity(Profissional profissional) {
        this.nome = profissional.getNome();
        this.valor = profissional.getValor().getQuantidadeCentavos();
        this.horarioInicio = profissional.getHorario().getAbertura();
        this.horarioFechamento = profissional.getHorario().getFechamento();
        this.id = profissional.getId();
        Set<EspecialidadeTableEntity> especialidadesTable = new HashSet<>();
        profissional.getEspecialidades()
                .forEach(especialidade -> especialidadesTable.add(new EspecialidadeTableEntity(especialidade)));
        this.especialidades = especialidadesTable;

    }

}
