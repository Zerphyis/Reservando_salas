package ms_email.salas.pessoas.controller;

import ms_email.salas.pessoas.Pessoas;
import ms_email.salas.pessoas.model.PessoasDto;
import ms_email.salas.pessoas.model.ServicePessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homepessoas")
public class ControllerPessoas {

    @Autowired
    ServicePessoa service;

    @PostMapping("/adicionar")
    public ResponseEntity<Pessoas> adicionarPessoa(@RequestBody PessoasDto pessoasDto) {
        return service.adicionarPessoa(pessoasDto);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Pessoas>> listarPessoas() {
        return service.listarPessoas();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pessoas> autalizarPessoa(@PathVariable Long id , @RequestBody PessoasDto pessoasDto){
        try {
            Pessoas pessoaAtualizada = service.atualizarPessoa(id, pessoasDto);

            if (pessoaAtualizada == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            return ResponseEntity.ok(pessoaAtualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirPessoa(@PathVariable Long id) {
        return service.excluirPessoas(id);
    }
}
