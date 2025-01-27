package saude.app.api.dto.paciente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPaciente(@NotBlank String nome,
                                    @NotBlank  @Pattern(regexp = "\\d{11}")
                                    String cpf,
                                    @NotBlank
                                    String telefone
                                    ) {
}
