package ms_email.salas.pessoas.model;

import ms_email.salas.pessoas.Pessoas;
import ms_email.salas.pessoas.TipoPessoa;

public record PessoasDto(String nome, String email, TipoPessoa tipoPessoa) {
    public PessoasDto(Pessoas pessoas){
        this(pessoas.getNome(), pessoas.getEmail(), pessoas.getTipoPessoa());
    }
}
