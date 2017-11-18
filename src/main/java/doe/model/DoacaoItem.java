package doe.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="DoacaoItem")
public class DoacaoItem implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IdDoacaoItem")
	private long idDoacaoItem;
	
	@Column(name="Quantidade")
	private int quantidade;

	@ManyToOne
	@JoinColumn(name="IdDoacao")
	private Doacao doacao;

	@ManyToOne
	@JoinColumn(name="IdItem")
	private Item item;

	public DoacaoItem() {
	}

	public long getIdDoacaoItem() {
		return idDoacaoItem;
	}

	public void setIdDoacaoItem(long idDoacaoItem) {
		this.idDoacaoItem = idDoacaoItem;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Doacao getDoacao() {
		return doacao;
	}

	public void setDoacao(Doacao doacao) {
		this.doacao = doacao;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
}