package br.com.invistatech.sucessows.model;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "fornecedor")
public class Fornecedor {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "id_prazo_pagamento")
	private PrazoPagamento prazoPagamento;
	
	@ManyToOne(optional=true, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_numero_funcionario")
	private NumeroFuncionario numeroFuncionario;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_porte")
	private Porte porte;
	
	@OneToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;
	@Column(length = 100)
	private String nome;
	@Column(length = 20)
	private String senha;
	@Column(length = 2)
	private String tipo;
	@Column(length = 30)
	private String status;
	@Column(name = "cpf_cnpj", length = 14)
	private String cpfCnpj;
	@Column(length = 20)
	private String rg;
	@Column(length = 100)
	private String pai;
	@Column(length = 100)
	private String mae;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Calendar dataNascimento;
	@Column(name = "razao_social", length = 200)
	private String razaoSocial;
	@Column(name = "nome_fantasia", length = 200)
	private String nomeFantasia;
	@Column(name = "e_cnpj")
	boolean eCnpj;
	@Column(length = 20)
	private String ie;
	@Column(length = 20)
	private String im;
	@Column(length = 200)
	private String endereco;
	@Column(length = 10)
	private String numero;
	@Column(length = 100)
	private String complemento;
	@Column(length = 9)
	private String cep;
	@Column(length = 100)
	private String bairro;
	@Column(length = 15)
	private String fone;
	@Column(length = 15)
	private String fax;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_fundacao")
	private Calendar dataFundacao;
	
	@ManyToOne(optional=true, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cnae_primario")
	private Cnae cnaePrimario;
	
	@ManyToOne(optional=true, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cnae_secundario")
	private Cnae cnaeSecundario;
	
	@Column(length = 3)
	private String frete;
	@Column(length = 1, name = "atividade_economica")
	private String atividadeEconomica;
	@Column(length = 2, name = "regime_tributacao")
	private String regimeTributacao;
	@Column(length = 500)
	private String comentario;
	
	@Column(name = "anexo_cartao_cnpj",length = 200)
	private String anexoCartaoCnpj;
	
	@Column(name = "anexo_sintegra",length = 200)
	private String anexoSintegra;
	@Column(name = "anexo_contrato_social",length = 200)
	private String anexoContratoSocial;
	@Column(name = "anexo_aditivo",length = 200)
	private String anexoAditivo;
	@Column(precision = 12, scale = 2)
	private BigInteger faturamento;
	@Column(name = "anexo_balanco",length = 200)
	private String anexoBalanco;
	private Integer banco;
	@Column(length = 10)
	private String agencia;
	@Column(length = 10)
	private String conta;
	@Column(length = 100)
	private String favorecido;
	@Column(name = "anexo_bancario",length = 200)
	private String anexoBancario;
	private Integer mtrc;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_avaliacao")
	private Calendar dataAvaliacao;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_fornecedor")
	private List<QuestionarioFornecedor> questionarios;
	
	@ManyToMany
    @JoinTable(name="questionario_avaliacao_fornecedor", 
    joinColumns={@JoinColumn(name="id_fornecedor")}, 
    inverseJoinColumns={@JoinColumn(name="id_questionario")})
    private List<QuestionarioAvaliacao> questionariosAvaliacao;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_fornecedor")
	private List<AnexoFornecedor> anexosFornecedor;
	
	@ManyToMany
    @JoinTable(name="estado_atuacao", 
    joinColumns = @JoinColumn(name="id_fornecedor"), 
    inverseJoinColumns = @JoinColumn(name="id_estado"))
	private List<Estado> estadoAtuacao;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_fornecedor")
	private List<ReferenciaComercial> referencias;
	
	@ManyToMany
    @JoinTable(name="fornecedor_categoria_nivel_3", 
    joinColumns= @JoinColumn(name="id_fornecedor"), 
    inverseJoinColumns=@JoinColumn(name="id_categoria_nivel_3"))
	private List<CategoriaNivel3> categoriasNivel3;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_fornecedor")
	private List<Contato> contatos;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_fornecedor")
	private List<Socio> socios;
	
	public boolean iseCnpj() {
		return eCnpj;
	}

	public void seteCnpj(boolean eCnpj) {
		this.eCnpj = eCnpj;
	}

	public List<Estado> getEstadoAtuacao() {
		return estadoAtuacao;
	}

	public void setEstadoAtuacao(List<Estado> estadoAtuacao) {
		this.estadoAtuacao = estadoAtuacao;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public PrazoPagamento getPrazoPagamento() {
		return prazoPagamento;
	}

	public void setPrazoPagamento(PrazoPagamento prazoPagamento) {
		this.prazoPagamento = prazoPagamento;
	}

	public NumeroFuncionario getNumeroFuncionario() {
		return numeroFuncionario;
	}

	public void setNumeroFuncionario(NumeroFuncionario numeroFuncionario) {
		this.numeroFuncionario = numeroFuncionario;
	}

	public Porte getPorte() {
		return porte;
	}

	public void setPorte(Porte porte) {
		this.porte = porte;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getIm() {
		return im;
	}

	public void setIm(String im) {
		this.im = im;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Calendar getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Calendar dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public Cnae getCnaePrimario() {
		return cnaePrimario;
	}

	public void setCnaePrimario(Cnae cnaePrimario) {
		this.cnaePrimario = cnaePrimario;
	}

	public Cnae getCnaeSecundario() {
		return cnaeSecundario;
	}

	public void setCnaeSecundario(Cnae cnaeSecundario) {
		this.cnaeSecundario = cnaeSecundario;
	}

	public String getFrete() {
		return frete;
	}

	public void setFrete(String frete) {
		this.frete = frete;
	}

	public String getAtividadeEconomica() {
		return atividadeEconomica;
	}

	public void setAtividadeEconomica(String atividadeEconomica) {
		this.atividadeEconomica = atividadeEconomica;
	}

	public String getRegimeTributacao() {
		return regimeTributacao;
	}

	public void setRegimeTributacao(String regimeTributacao) {
		this.regimeTributacao = regimeTributacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getAnexoCartaoCnpj() {
		return anexoCartaoCnpj;
	}

	public void setAnexoCartaoCnpj(String anexoCartaoCnpj) {
		this.anexoCartaoCnpj = anexoCartaoCnpj;
	}

	public String getAnexoSintegra() {
		return anexoSintegra;
	}

	public void setAnexoSintegra(String anexoSintegra) {
		this.anexoSintegra = anexoSintegra;
	}

	public String getAnexoContratoSocial() {
		return anexoContratoSocial;
	}

	public void setAnexoContratoSocial(String anexoContratoSocial) {
		this.anexoContratoSocial = anexoContratoSocial;
	}

	public String getAnexoAditivo() {
		return anexoAditivo;
	}

	public void setAnexoAditivo(String anexoAditivo) {
		this.anexoAditivo = anexoAditivo;
	}

	public BigInteger getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(BigInteger faturamento) {
		this.faturamento = faturamento;
	}

	public String getAnexoBalanco() {
		return anexoBalanco;
	}

	public void setAnexoBalanco(String anexoBalanco) {
		this.anexoBalanco = anexoBalanco;
	}

	public Integer getBanco() {
		return banco;
	}

	public void setBanco(Integer banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getFavorecido() {
		return favorecido;
	}

	public void setFavorecido(String favorecido) {
		this.favorecido = favorecido;
	}

	public String getAnexoBancario() {
		return anexoBancario;
	}

	public void setAnexoBancario(String anexoBancario) {
		this.anexoBancario = anexoBancario;
	}

	public Integer getMtrc() {
		return mtrc;
	}

	public void setMtrc(Integer mtrc) {
		this.mtrc = mtrc;
	}

	public Calendar getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Calendar dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public List<QuestionarioAvaliacao> getQuestionariosAvaliacao() {
		return questionariosAvaliacao;
	}

	public void setQuestionariosAvaliacao(List<QuestionarioAvaliacao> questionariosAvaliacao) {
		this.questionariosAvaliacao = questionariosAvaliacao;
	}
	
	public List<AnexoFornecedor> getAnexosFornecedor() {
		return anexosFornecedor;
	}

	public void setAnexosFornecedor(List<AnexoFornecedor> anexosFornecedor) {
		this.anexosFornecedor = anexosFornecedor;
	}

	public List<ReferenciaComercial> getReferencias() {
		return referencias;
	}

	public void setReferencias(List<ReferenciaComercial> referencias) {
		this.referencias = referencias;
	}

	public List<CategoriaNivel3> getCategoriasNivel3() {
		return categoriasNivel3;
	}

	public void setCategoriasNivel3(List<CategoriaNivel3> categoriasNivel3) {
		this.categoriasNivel3 = categoriasNivel3;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public List<QuestionarioFornecedor> getQuestionarios() {
		return questionarios;
	}

	public void setQuestionarios(List<QuestionarioFornecedor> questionarios) {
		this.questionarios = questionarios;
	}

	public List<Socio> getSocios() {
		return socios;
	}

	public void setSocios(List<Socio> socios) {
		this.socios = socios;
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
		Fornecedor other = (Fornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
