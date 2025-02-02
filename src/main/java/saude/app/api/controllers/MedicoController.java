package saude.app.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saude.app.api.dto.medico.DadosAtualizacaoMedico;
import saude.app.api.dto.medico.DadosCadastroMedico;
import saude.app.api.dto.medico.DadosListagemMedico;
import saude.app.api.models.Medico;
import saude.app.api.repositories.MedicoRepository;

@RequestMapping("/medicos")
@RestController
public class MedicoController {

    @Autowired
    private final MedicoRepository repository;

    public MedicoController(MedicoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<DadosListagemMedico> listarAtivos(
            @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findByAtivoTrue(paginacao)
                .map(DadosListagemMedico::new);
    }

    @GetMapping("/inativos")
    public Page<DadosListagemMedico> listarInativos(
            @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findByAtivoFalse(paginacao)
                .map(DadosListagemMedico::new);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        Medico medico = new Medico(dados);
        repository.save(medico);
        return ResponseEntity.status(201).body("Médico cadastrado com sucesso!");

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        repository.getReferenceById(id).inativar();
    }
}
