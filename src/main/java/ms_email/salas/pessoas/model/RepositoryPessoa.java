package ms_email.salas.pessoas.model;

import ms_email.salas.pessoas.Pessoas;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPessoa extends JpaRepository<Pessoas, Long> {
}
