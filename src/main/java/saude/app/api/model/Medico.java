package saude.app.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import saude.app.api.dto.DadosAtualizacaoMedico;
import saude.app.api.dto.DadosCadastroMedico;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Medico")
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    private Boolean ativo;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.crm() != null) {
            this.crm = dados.crm();
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}


