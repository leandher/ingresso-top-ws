package br.com.invistatech.sucessows.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "anexo_fornecedor")
public class AnexoFornecedor {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_anexo")
	private Anexo anexo;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_validade")
	private Calendar dataValidade;
	@Column(name = "anexo")
	private String path;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Anexo getAnexo() {
		return anexo;
	}
	
	public void setAnexo(Anexo anexo) {
		this.anexo = anexo;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}
	
	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
}
