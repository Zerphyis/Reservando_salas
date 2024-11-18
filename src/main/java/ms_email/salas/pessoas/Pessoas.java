package ms_email.salas.pessoas;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "tb_pessoa")
public class Pessoas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    @Email
    String email;
    @Enumerated(EnumType.STRING)
    TipoPessoa tipoPessoa;

    public Pessoas(String nome, String email, TipoPessoa tipoPessoa) {
        this.nome = nome;
        this.email = email;
        this.tipoPessoa = tipoPessoa;
    }
    public Pessoas(){

    }



    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
