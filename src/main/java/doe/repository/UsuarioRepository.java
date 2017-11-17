package doe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import doe.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByLoginLikeAndSenhaLike(String login, String senha);
	
}
