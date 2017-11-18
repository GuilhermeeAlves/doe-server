package doe.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdUsuario")
	private long idUsuario;
    
	@Column(name="Login", unique=true)
    private String login;
	
	@Column(name="Senha")
    private String senha;
    
    @JsonIgnore
	@OneToMany(mappedBy="usuario")
	private List<Doacao> doacoes;

    public Usuario() {
    }

	public long getId() {
		return idUsuario;
	}

	public void setId(long id) {
		this.idUsuario = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Doacao> getDoacoes() {
		return doacoes;
	}

	public void setDoacoes(List<Doacao> doacoes) {
		this.doacoes = doacoes;
	}
}
