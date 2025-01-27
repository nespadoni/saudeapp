package saude.app.api.dto.medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import saude.app.api.models.Especialidade;

public record DadosCadastroMedico(@NotBlank(message = "O nome do médico é obrigatório") String nome,

                                  @NotBlank(message = "O CRM do médico é obrigatório") @Pattern(regexp = "\\d{4,6}") String crm,

                                  @NotNull(message = "A especialidade do médico é obrigatória") Especialidade especialidade) {
}