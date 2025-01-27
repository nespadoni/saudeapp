package saude.app.api.dto.consulta;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import saude.app.api.models.Medico;
import saude.app.api.models.Paciente;

import java.util.Date;

public record DadosAtualizacaoConsulta(
        @NotNull
        Long id,

        Paciente paciente,

        Medico medico,

        Date dataHora,

        String local) {
}
