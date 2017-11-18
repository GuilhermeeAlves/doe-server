package doe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import doe.model.Usuario;
import doe.repository.UsuarioRepository;

@Controller
@RequestMapping(path = "usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@RequestMapping(value = "{login}/{senha}", method = RequestMethod.POST)
	public ResponseEntity<Usuario> autentica(@PathVariable String login, @PathVariable String senha) {

		Usuario usuario = this.usuarioRepo.findByLoginLikeAndSenhaLike(login, senha);
		
		
		if(usuario==null) {
			return new ResponseEntity(new CustomErrorType("Login/Senha Incorretos"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Usuario> postCadastrar(@RequestBody Usuario usuario) {

		usuario = this.usuarioRepo.save(usuario);

		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<?> putAtualizar(@RequestBody Usuario usuario) {
		
		if(this.usuarioRepo.findOne(usuario.getId())==null) {
			   return new ResponseEntity(new CustomErrorType("Nao foi possivel atualizar. Cliente com codCliente " + usuario.getId() + " nao encontrado."),
	                    HttpStatus.NOT_FOUND);
		}	
		
		this.usuarioRepo.save(usuario);
		
		return new ResponseEntity<>(HttpStatus.CREATED);		
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePorId(@PathVariable long id) {
		if(this.usuarioRepo.findOne(id)==null) {
			   return new ResponseEntity(new CustomErrorType("Nao foi possivel deletar. Cliente com codCliente " + id + " nao encontrado."),
	                    HttpStatus.NOT_FOUND);
		}
		
		this.usuarioRepo.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);	
		
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable long id) {
		
		Usuario usuario = this.usuarioRepo.findOne(id);
		
		if(usuario==null) {
			   return new ResponseEntity(new CustomErrorType("Nao foi possivel buscar o Usuario com id " + id + "."),
	                    HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> buscarTodos() {
		
		List<Usuario> listaUsuarios = this.usuarioRepo.findAll();		
		
		return new ResponseEntity<List<Usuario>>(listaUsuarios, HttpStatus.OK);
		
	}

}
