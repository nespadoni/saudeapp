package saude.app.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saude.app.api.dto.consulta.DadosAtualizacaoConsulta;
import saude.app.api.dto.consulta.DadosCadastroConsulta;
import saude.app.api.dto.consulta.DadosListagemConsulta;
import saude.app.api.models.Consulta;
import saude.app.api.repositories.ConsultaRepository;

@RequestMapping("/consultas")
@RestController
public class ConsultaController {

    @GetMapping("/filtrar")
    public Page<DadosListagemConsulta> listarPorDataHora(
            @RequestParam(required = false) String dataHora,
            @RequestParam(required = false) String local,
            @RequestParam(required = false) Long medicoId,
            @RequestParam(required = false) Long pacienteId,
            @PageableDefault(size = 10, sort = {"dataHora"}) Pageable paginacao) {
        return repository.findByDataHora(dataHora, paginacao)
                .map(DadosListagemConsulta::new);
    }

    @Autowired
    private final ConsultaRepository repository;

    public ConsultaController(ConsultaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<DadosListagemConsulta> listarAtivos (@PageableDefault(size = 10, sort = {"dataHora"}) Pageable paginacao) {
        return repository.findByAtivoTrue(paginacao)
                .map(DadosListagemConsulta::new);
    }

    @GetMapping("/inativos")
    public Page<DadosListagemConsulta> listarInativos (@PageableDefault(size = 10, sort = {"dataHora"}) Pageable paginacao) {
        return repository.findByAtivoFalse(paginacao)
                .map(DadosListagemConsulta::new);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastroConsulta dados) {
        Consulta consulta = new Consulta(dados);
        repository.save(consulta);
        return ResponseEntity.status(201).body("Consulta cadastrada com sucesso!");

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoConsulta dados) {
        var consulta = repository.getReferenceById(dados.id());
        consulta.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        repository.getReferenceById(id).inativar();
    }
}

