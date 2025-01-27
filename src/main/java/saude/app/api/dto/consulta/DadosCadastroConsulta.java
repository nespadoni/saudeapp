package saude.app.api.dto.consulta;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import saude.app.api.models.Medico;
import saude.app.api.models.Paciente;

import java.util.Date;

public record DadosCadastroConsulta(
        @Valid
        @NotNull(message = "Paciente não pode ser nulo.")
        Paciente paciente,

        @Valid
        @NotNull(message = "Médico não pode ser nulo.")
        Medico medico,

        @NotNull(message = "A data e hora da consulta não podem ser nulas.")
        Date dataHora,

        @NotBlank
        String local) {

}
