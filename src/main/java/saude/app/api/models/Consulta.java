package saude.app.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import saude.app.api.dto.consulta.DadosAtualizacaoConsulta;
import saude.app.api.dto.consulta.DadosCadastroConsulta;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Consulta")
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    private Date dataHora;
    private String local;
    private Boolean ativo;

    public Consulta(DadosCadastroConsulta dados) {
        this.paciente = dados.paciente();
        this.medico = dados.medico();
        this.dataHora = dados.dataHora();
        this.local = dados.local();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoConsulta dados) {
        if (dados.paciente() != null) {
            this.paciente = dados.paciente();
        }
        if (dados.medico() != null) {
            this.medico = dados.medico();
        }
        if (dados.dataHora() != null) {
            this.dataHora = dados.dataHora();
        }
        if (dados.local() != null) {
            this.local = dados.local();
        }
    }

    public void inativar() {
        this.ativo = false;
    }

}
