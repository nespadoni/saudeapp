package saude.app.api.dto.paciente;

import saude.app.api.models.Paciente;

public record DadosListagemPaciente(Long id, String nome, String cpf, String telefone) {

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getTelefone());
    }
}
