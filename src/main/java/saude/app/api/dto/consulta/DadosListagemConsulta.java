package saude.app.api.dto.consulta;

import saude.app.api.models.Consulta;
import saude.app.api.models.Medico;
import saude.app.api.models.Paciente;

import java.util.Date;

public record DadosListagemConsulta(Long id, Paciente paciente, Medico medico, Date dataHora, String local) {

    public DadosListagemConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getPaciente(), consulta.getMedico(), consulta.getDataHora(), consulta.getLocal());
    }
}
