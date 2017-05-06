package br.com.invistatech.sucessows.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Anexo {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Column(length = 50)
	private String descricao;
	private Integer vencimento;
	private boolean obrigatorio;
	private boolean inativo;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getVencimento() {
		return vencimento;
	}
	public void setVencimento(Integer vencimento) {
		this.vencimento = vencimento;
	}
	public boolean isObrigatorio() {
		return obrigatorio;
	}
	public void setObrigatorio(boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}
	public boolean isInativo() {
		return inativo;
	}
	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}

	@Override
	public String toString() {
		return "Anexo [id=" + id + ", descricao=" + descricao + ", vencimento=" + vencimento + ", obrigatorio="
				+ obrigatorio + ", inativo=" + inativo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anexo other = (Anexo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
