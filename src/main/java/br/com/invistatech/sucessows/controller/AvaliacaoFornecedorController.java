package br.com.invistatech.sucessows.controller;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.invistatech.sucessows.model.Contato;
import br.com.invistatech.sucessows.model.Fornecedor;
import br.com.invistatech.sucessows.service.FornecedorService;
import br.com.invistatech.sucessows.service.QuestionarioFornecedorService;
import br.com.invistatech.sucessows.util.EmailSender;
import br.com.invistatech.sucessows.util.StringHash;

@Transactional
@CrossOrigin("*")
@RequestMapping("avaliacao-fornecedor")
@Controller
public class AvaliacaoFornecedorController {

	@Autowired
	private FornecedorService fornecedorService;
	
	@Autowired
	private EmailSender emailSender;
	
	@Autowired
	private QuestionarioFornecedorService qfService;
	
	@RequestMapping(value = "/{id}/status/{status}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> atualizarStatus(@PathVariable("id") Long id, @PathVariable("status") String status, 
			HttpServletResponse httpServletResponse) {
		Fornecedor fornecedor = fornecedorService.getFornecedor(id);
		if("HABILITADO".equals(status)
				|| "INDEFERIDO".equals(status)
				|| "PENDENTE".equals(status)
				|| "HOMOLOGADO".equals(status)
				|| "DESABILITADO".equals(status)
				|| "BLOQUEADO".equals(status)) {
			
			fornecedor.setStatus(status);
		}
		
		if("HABILITADO".equals(status)){
			String senha = new StringHash().randomString(6);
			fornecedor.setSenha(new StringHash().encode(senha));
			
			for(Contato contato : fornecedor.getContatos()){
				
				if(fornecedor.getNome() == null){ 
					emailSender.enviarEmailAtivacao(fornecedor.getRazaoSocial(), contato.getEmail(),fornecedor.getCpfCnpj(), senha);
				}
				
				if(fornecedor.getRazaoSocial() == null){ 
					emailSender.enviarEmailAtivacao(fornecedor.getNome(), contato.getEmail(), fornecedor.getCpfCnpj(), senha);
				}
				
			}
		}
		
		fornecedorService.alterar(fornecedor);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/fornecedor/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fornecedor> getFornecedor(@PathVariable("id") Long id) {
		Fornecedor f = fornecedorService.getFornecedor(id);
		f.setCategoriasNivel3(fornecedorService.getCategorias(id));
		f.setQuestionarios(qfService.getQuestionariosByFornecedor(id));
		return new ResponseEntity<Fornecedor>(f, HttpStatus.OK);
	}
}
