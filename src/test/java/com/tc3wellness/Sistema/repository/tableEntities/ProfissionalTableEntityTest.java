package com.tc3wellness.Sistema.repository.tableEntities;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import com.tc3wellness.Sistema.entity.Profissional;
import com.tc3wellness.Sistema.repository.JpaRepository.tableEntities.EspecialidadeTableEntity;
import com.tc3wellness.Sistema.repository.JpaRepository.tableEntities.ProfissionalTableEntity;

public class ProfissionalTableEntityTest {
    @Test
    void testToProfissionalEntidade() {
        ProfissionalTableEntity objetoInicio;
        objetoInicio = new ProfissionalTableEntity();

        objetoInicio.setNome("nome do teste");
        objetoInicio.setValor(576);

        UUID id = UUID.randomUUID();
        objetoInicio.setId(id);

        objetoInicio.setHorarioFechamento(LocalTime.NOON);
        objetoInicio.setHorarioInicio(LocalTime.MIDNIGHT);

        EspecialidadeTableEntity especialidade1 = new EspecialidadeTableEntity(UUID.randomUUID(), "Nome 1",
                "Descrição 1", Set.of());

        EspecialidadeTableEntity especialidade2 = new EspecialidadeTableEntity(UUID.randomUUID(), "Nome 2",
                "Descrição 2", Set.of());
        Set<EspecialidadeTableEntity> listaEspecialidades = new HashSet<>();
        listaEspecialidades.add(especialidade1);
        listaEspecialidades.add(especialidade2);

        objetoInicio.setEspecialidades(listaEspecialidades);

        Profissional objetoFinal = objetoInicio.toProfissionalEntidade();

        assertThat(objetoFinal.getId()).isEqualTo(id);
        assertThat(objetoFinal.getHorario().getAbertura()).isEqualTo(LocalTime.MIDNIGHT);
        assertThat(objetoFinal.getHorario().getFechamento()).isEqualTo(LocalTime.NOON);
        assertThat(objetoFinal.getNome()).isEqualTo("nome do teste");
        assertThat(objetoFinal.getValor().valorEmCentavos()).isEqualTo(576);
        assertThat(objetoFinal.getEspecialidades()).contains(especialidade1.toEspecialidadeEntidade(),
                especialidade2.toEspecialidadeEntidade());
    }
}
