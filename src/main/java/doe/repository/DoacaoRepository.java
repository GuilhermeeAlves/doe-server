package doe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import doe.model.Doacao;

public interface DoacaoRepository extends JpaRepository<Doacao, Long> {

}
