package doe.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name="Item")
public class Item implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IdItem")
	private long idItem;
	
	@Column(name="Observacao")
	private String observacao;
	
	@Column(name="Qualidade")
	private String qualidade;
	// em condições de uso, em boas condições de uso e em ótimas condições de uso

	@Column(name="Categoria")
	private String Categoria;
	// roupas, calçados, colchões, móveis, brinquedos, livros literários, eletrodomésticos, linha branca, eletrônicos, informática, utensílios domésticos
	
	@JsonIgnore
	@OneToMany(mappedBy="item")
	private List<DoacaoItem> doacoes;
	
	public Item() {
	}

	public long getIdItem() {
		return idItem;
	}

	public void setIdItem(long idItem) {
		this.idItem = idItem;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getQualidade() {
		return qualidade;
	}

	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public List<DoacaoItem> getDoacoes() {
		return doacoes;
	}

	public void setDoacoes(List<DoacaoItem> doacoes) {
		this.doacoes = doacoes;
	}
	
	
}