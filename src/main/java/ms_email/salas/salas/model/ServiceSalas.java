package ms_email.salas.salas.model;

import jakarta.transaction.Transactional;
import ms_email.salas.pessoas.TipoPessoa;
import ms_email.salas.pessoas.model.RepositoryPessoa;
import ms_email.salas.salas.Salas;
import ms_email.salas.salas.TipoSalas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceSalas {

    @Autowired
    private SalasRepository repository;

    @Autowired
    private RepositoryPessoa repositoryPessoa;

    @Transactional
    public ResponseEntity<Salas> criandoSalas(Salas sala) {
        if (!repositoryPessoa.existsById(sala.getReservista())) {
            return ResponseEntity.badRequest().body(null);
        }

        if (!repositoryPessoa.existsById(sala.getIdDoPalestrante())) {
            return ResponseEntity.badRequest().body(null);
        }

        if (sala.getTipoPessoa() == TipoPessoa.EDUCATIVA &&
                sala.getTipoSalas() != TipoSalas.AUDITORIO &&
                sala.getTipoSalas() != TipoSalas.CONFERENCIA) {
            return ResponseEntity.badRequest().build();
        }

        Salas novaSala = repository.save(sala);
        return ResponseEntity.ok(novaSala);
    }


    public ResponseEntity<List<Salas>> listarSalas() {
        List<Salas> salas = repository.findAll();
        return ResponseEntity.ok(salas);
    }

    public ResponseEntity<Salas> buscarSalaPorId(Long id) {
        Optional<Salas> sala = repository.findById(id);
        return sala.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    public ResponseEntity<Salas> atualizarSala(Long id, Salas salaAtualizada) {
        Optional<Salas> salaExistente = repository.findById(id);

        if (salaExistente.isPresent()) {
            Salas sala = salaExistente.get();

            if (salaAtualizada.getTipoPessoa() == TipoPessoa.EDUCATIVA &&
                    salaAtualizada.getTipoSalas() != TipoSalas.AUDITORIO &&
                    salaAtualizada.getTipoSalas() != TipoSalas.CONFERENCIA) {
                return ResponseEntity.badRequest().build();
            }

            sala.setHoraInicial(salaAtualizada.getHoraInicial());
            sala.setHoraFinal(salaAtualizada.getHoraFinal());
            sala.setIdDoReservista(salaAtualizada.getIdDoReservista());
            sala.setIdDoPalestrante(salaAtualizada.getIdDoPalestrante());
            sala.setQuantidadeDePessoas(salaAtualizada.getQuantidadeDePessoas());
            sala.setTipoSalas(salaAtualizada.getTipoSalas());
            sala.setTipoPessoa(salaAtualizada.getTipoPessoa());

            repository.save(sala);
            return ResponseEntity.ok(sala);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    public ResponseEntity<Void> deletarSala(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
