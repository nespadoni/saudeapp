package saude.app.api.dto.medico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
    @NotNull
    Long id,
    String nome,
    String crm,
    String especialidade
){
}
