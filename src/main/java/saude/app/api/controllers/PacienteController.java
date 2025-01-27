package saude.app.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saude.app.api.dto.paciente.DadosAtualizacaoPaciente;
import saude.app.api.dto.paciente.DadosCadastroPaciente;
import saude.app.api.dto.paciente.DadosListagemPaciente;
import saude.app.api.models.Paciente;
import saude.app.api.repositories.PacienteRepository;

@RequestMapping("/pacientes")
@RestController
public class PacienteController {

    @Autowired
    private final PacienteRepository repository;

    public PacienteController(PacienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<DadosListagemPaciente> listarAtivos(
            @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findByAtivoTrue(paginacao)
                .map(DadosListagemPaciente::new);
    }

    @GetMapping("/inativos")
    public Page<DadosListagemPaciente> listarInativos(
            @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findByAtivoFalse(paginacao)
                .map(DadosListagemPaciente::new);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        Paciente paciente = new Paciente(dados);
        repository.save(paciente);
        return ResponseEntity.status(201).body("Paciente cadastrado com sucesso!");

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        repository.getReferenceById(id).inativar();
    }
}
