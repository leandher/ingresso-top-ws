package br.com.invistatech.sucessows.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.invistatech.sucessows.model.CategoriaNivel3;
import br.com.invistatech.sucessows.model.Estado;
import br.com.invistatech.sucessows.model.Fornecedor;
import br.com.invistatech.sucessows.repository.FornecedorRepository;

@Service
public class FornecedorService {
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public List<Fornecedor> getListaFornecedor(){
		return fornecedorRepository.findAll();
	}
	
	public Fornecedor getFornecedor(Long id){
		return fornecedorRepository.findOne(id);
	}
	
	public Fornecedor save(Fornecedor fornecedor){
		return fornecedorRepository.save(fornecedor);
	}
	
	public Fornecedor alterar(Fornecedor fornecedor){
		return fornecedorRepository.save(fornecedor);
	}
	
	public void deleta(Long id){
		 fornecedorRepository.delete(id);
	}
	
	public Fornecedor getFornecedorByCpfCnpj(String cpfCnpj){
		return fornecedorRepository.getFornecedorByCpfCnpj(cpfCnpj);
	}
	
	public Fornecedor login(String cpfCnpj, String senha){
		return fornecedorRepository.login(cpfCnpj, senha);
	}
	
	public List<Estado> getEstadoAtuacao(Long id){
		return fornecedorRepository.getEstadosAtuacao(id);
	}
	
	public List<Fornecedor> all(){
		return fornecedorRepository.all();
	}
	
	public List<CategoriaNivel3> getCategorias(Long id){
		return fornecedorRepository.getCategorias(id);
	}

	public void atualizarStatus(Long id, String status) {
		Fornecedor fornecedor = fornecedorRepository.findOne(id);
		fornecedor.setStatus(status);
		
		fornecedorRepository.save(fornecedor);
	}
	
	public void atualizarSenha(Long id, String senha) {
		Fornecedor fornecedor = fornecedorRepository.findOne(id);
		fornecedor.setSenha(senha);
		
		fornecedorRepository.save(fornecedor);
	}
}
