package saude.app.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import saude.app.api.model.Especialidade;
import saude.app.api.model.Medico;

public record DadosListagemMedico(Long id, String nome, String crm, Especialidade especialidade, Boolean ativo) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEspecialidade(), medico.getAtivo());
    }
}
