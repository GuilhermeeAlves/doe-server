package doe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by REMOR on 09/08/2016.
 */
@Entity
public class Usuario implements Serializable {
    private String nome;
    @Column(unique=true)
    private String login;
    private String senha;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    public Usuario() {
    }

    public Usuario(long id, String nome, String login, String senha) {
        this.id = id;
    	this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}    
}
