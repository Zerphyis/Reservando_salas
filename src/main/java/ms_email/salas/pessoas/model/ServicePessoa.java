package ms_email.salas.pessoas.model;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import ms_email.salas.pessoas.Pessoas;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class ServicePessoa {
    @Autowired
    RepositoryPessoa repository;

    @Transactional
    public ResponseEntity adicionarPessoa(@RequestBody PessoasDto pessoas){
        Pessoas novaPessoa = new Pessoas(pessoas.nome(), pessoas.email(), pessoas.tipoPessoa());
        Pessoas pessoaCadastrada = repository.save(novaPessoa);
        return ResponseEntity.ok(pessoaCadastrada);
    }

    public ResponseEntity<List<Pessoas>> listarPessoas() {
        List<Pessoas> pessoas = repository.findAll();
        return ResponseEntity.ok(pessoas);

    }
    @Transactional
    public Pessoas atualizarPessoa(Long id, PessoasDto pessoasDto) {
        Optional<Pessoas> pessoaOpt = repository.findById(id);

        if (pessoaOpt.isEmpty()) {
            return null;
        }

        Pessoas pessoa = pessoaOpt.get();

        pessoa.setEmail(pessoasDto.email());
        pessoa.setNome(pessoasDto.nome());
        pessoa.setTipoPessoa(pessoasDto.tipoPessoa());


        return repository.save(pessoa);
    }

    public ResponseEntity<?> excluirPessoas(Long id) {
        try {
            var pessoa = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));

            repository.delete(pessoa);

            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Erro ao excluir pessoa");
        }
    }
}

