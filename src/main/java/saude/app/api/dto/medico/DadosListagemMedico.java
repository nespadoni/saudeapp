package saude.app.api.dto.medico;

import saude.app.api.models.Especialidade;
import saude.app.api.models.Medico;

public record DadosListagemMedico(Long id, String nome, String crm, Especialidade especialidade, Boolean ativo) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEspecialidade(), medico.getAtivo());
    }
}
