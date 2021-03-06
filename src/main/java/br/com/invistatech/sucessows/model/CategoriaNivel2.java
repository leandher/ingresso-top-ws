package br.com.invistatech.sucessows.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "categoria_nivel_2")
public class CategoriaNivel2 {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_categoria_nivel_1")
	private CategoriaNivel1 categoriaNivel1;
	@Column(length = 50)
	private String descricao;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public CategoriaNivel1 getCategoriaNivel1() {
		return categoriaNivel1;
	}

	public void setCategoriaNivel1(CategoriaNivel1 categoriaNivel1) {
		this.categoriaNivel1 = categoriaNivel1;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "CateagoriaNivel2 [id=" + id + ",Descrição=" + descricao + "]";
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
		CategoriaNivel2 other = (CategoriaNivel2) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
