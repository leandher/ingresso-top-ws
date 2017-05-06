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
@Table(name = "tramitacao_fornecedor")
public class TramitacaoFornecedor {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_fornecedor")
	private Fornecedor fornecedor;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_tramitacao")
	private Calendar dataTramitacao;
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	private Integer statusFornecedor;
	private String operacao;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Calendar getDataTramitacao() {
		return dataTramitacao;
	}

	public void setDataTramitacao(Calendar dataTramitacao) {
		this.dataTramitacao = dataTramitacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getStatusFornecedor() {
		return statusFornecedor;
	}

	public void setStatusFornecedor(Integer statusFornecedor) {
		this.statusFornecedor = statusFornecedor;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
}
