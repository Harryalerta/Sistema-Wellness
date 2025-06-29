package com.tc3wellness.Sistema.gateway;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tc3wellness.Sistema.data.CadastrarEspecialidadeRequisicao;
import com.tc3wellness.Sistema.data.CadastrarEstabelecimentoRequisicao;
import com.tc3wellness.Sistema.data.CadastrarProfissionalRequisicao;
import com.tc3wellness.Sistema.data.VincularEspecialidadeRequisicao;
import com.tc3wellness.Sistema.data.VincularEstabelecimentoRequisicao;
import com.tc3wellness.Sistema.entity.Especialidade;
import com.tc3wellness.Sistema.entity.Estabelecimento;
import com.tc3wellness.Sistema.entity.Profissional;
import com.tc3wellness.Sistema.usecase.CadastroUsecase;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/cadastro")
public class CadastroGateway {

    private final CadastroUsecase cadastroUsecase;

    public CadastroGateway(CadastroUsecase usecase) {
        this.cadastroUsecase = usecase;
    }

    @Operation(summary = "Cadastrar um profissional de Wellness", tags = "Profissional")
    @PostMapping("/profissional")
    public ResponseEntity<Profissional> cadastrarProfissional(@RequestBody CadastrarProfissionalRequisicao requisicao) {
        try {
            return Optional.ofNullable(cadastroUsecase.cadastrarProfissiona(requisicao))
                    .map(resultado -> ResponseEntity.ok()
                            .body(resultado))
                    .orElseGet(() -> ResponseEntity.internalServerError().build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Cadastrar uma especialidade de trabalho", tags = "Profissional")
    @PostMapping("/especialidade")
    public ResponseEntity<Especialidade> cadastrarEspecialidade(
            @RequestBody CadastrarEspecialidadeRequisicao requisicao) {
        try {
            return Optional.ofNullable(cadastroUsecase.cadastrarEspecialidade(requisicao))
                    .map(resultado -> ResponseEntity.ok()
                            .body(resultado))
                    .orElseGet(() -> ResponseEntity.internalServerError().build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Cadastrar um estabelecimento de Wellness", tags = "Estabelecimento")
    @PostMapping("/estabelecimento")
    public ResponseEntity<Estabelecimento> cadastrarEspecialidade(
            @RequestBody CadastrarEstabelecimentoRequisicao requisicao) {
        try {
            return Optional.ofNullable(cadastroUsecase.cadastrarEstabelecimento(requisicao))
                    .map(resultado -> ResponseEntity.ok()
                            .body(resultado))
                    .orElseGet(() -> ResponseEntity.internalServerError().build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Vincular uma especialidade a um profissional", tags = "Profissional")
    @PostMapping("/vincular_especialidade")
    public ResponseEntity<Profissional> vincularEspecialidade(@RequestBody VincularEspecialidadeRequisicao requisicao) {
        try {
            return Optional.ofNullable(cadastroUsecase.vincularEspecialidades(requisicao))
                    .map(resultado -> ResponseEntity.ok()
                            .body(resultado))
                    .orElseGet(() -> ResponseEntity.internalServerError().build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @Operation(summary = "Vincular um Profissional a um Estabelecimento", tags = "Estabelecimento")
    @PostMapping("/vincular_estabelecimento")
    public ResponseEntity<Estabelecimento> vincularEstabelecimento(@RequestBody VincularEstabelecimentoRequisicao requisicao) {
        try {
            return Optional.ofNullable(cadastroUsecase.vincularEstabelecimento(requisicao))
                    .map(resultado -> ResponseEntity.ok()
                            .body(resultado))
                    .orElseGet(() -> ResponseEntity.internalServerError().build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}