package br.com.invistatech.sucessows.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import br.com.invistatech.sucessows.model.CategoriaNivel3;
import br.com.invistatech.sucessows.model.Contato;
import br.com.invistatech.sucessows.model.Estado;
import br.com.invistatech.sucessows.model.Fornecedor;
import br.com.invistatech.sucessows.model.ReferenciaComercial;
import br.com.invistatech.sucessows.service.ContatoService;
import br.com.invistatech.sucessows.service.FornecedorService;
import br.com.invistatech.sucessows.service.ReferenciaComercialService;
import br.com.invistatech.sucessows.util.EmailSender;
import br.com.invistatech.sucessows.util.StringHash;
import br.com.invistatech.sucessows.util.UploadArquivos;

@Transactional
@CrossOrigin("*")
@RequestMapping("/fornecedor")
@Controller
public class FornecedorController {
	@Autowired
	private FornecedorService fornecedorService;
	
	@Autowired
	private ContatoService contatoService;
	
	@Autowired
	private ReferenciaComercialService referenciaComercialService;
	
	@Autowired
	private EmailSender emailSender;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fornecedor> getFornecedor(@PathVariable("id") Long id) {
		return new ResponseEntity<Fornecedor>(fornecedorService.getFornecedor(id), HttpStatus.OK);

	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Fornecedor>> getListaFornecedor() {
		return new ResponseEntity<List<Fornecedor>>(fornecedorService.getListaFornecedor(), HttpStatus.OK);

	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fornecedor> save(@RequestBody Fornecedor fornecedor) {
		fornecedor.setStatus("CADASTRADO");
		return new ResponseEntity<Fornecedor>(fornecedorService.save(fornecedor), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/alterar", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE, consumes = {"multipart/form-data" })
	public ResponseEntity<String> edit(@RequestPart("files[]") List<MultipartFile> files,
			@RequestPart("fornecedor") Fornecedor fornecedor, HttpServletRequest request) {
		
		Fornecedor f = fornecedorService.getFornecedor(fornecedor.getId());
		fornecedor.setAnexoCartaoCnpj(f.getAnexoCartaoCnpj());
		fornecedor.setAnexoSintegra(f.getAnexoSintegra());
		fornecedor.setAnexoContratoSocial(f.getAnexoContratoSocial());
		fornecedor.setAnexoAditivo(f.getAnexoAditivo());
		
		String path = null;
		for (MultipartFile file : files) {
			
			String s = file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf("."));
			if (s.equals("cartaoCnpj")) {
				new UploadArquivos().deleteAnexo(f.getAnexoCartaoCnpj(), request);
			}
			if (s.equals("sintegra")) {
				new UploadArquivos().deleteAnexo(f.getAnexoSintegra(), request);
			}
			if (s.equals("contratoSocial")) {
				new UploadArquivos().deleteAnexo(f.getAnexoContratoSocial(), request);
			}
			if (s.equals("aditivo")){
				new UploadArquivos().deleteAnexo(f.getAnexoAditivo(), request);
			}
			
			String nome = new StringHash().randomString(50) + "-" + file.getOriginalFilename();
			path = new UploadArquivos().uploadAnexo(file, nome, "upload/fornecedor/anexo", request);

			if (s.equals("cartaoCnpj")) {
				fornecedor.setAnexoCartaoCnpj(path);
			}
			if (s.equals("sintegra")) {
				fornecedor.setAnexoSintegra(path);
			}
			if (s.equals("contratoSocial")) {
				fornecedor.setAnexoContratoSocial(path);
			}
			if (s.equals("aditivo")) {
				fornecedor.setAnexoAditivo(path);
			}
		}
		
		fornecedorService.alterar(fornecedor);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = { "multipart/form-data" })
	public ResponseEntity<Fornecedor> delete(@PathVariable("id") Long id, HttpServletRequest request) {
		Fornecedor fornecedor = fornecedorService.getFornecedor(id);
		fornecedorService.deleta(id);
		if (fornecedor.getAnexoCartaoCnpj() != null) {
			new UploadArquivos().deleteAnexo(fornecedor.getAnexoCartaoCnpj(), request);
		}
		if (fornecedor.getAnexoSintegra() != null) {
			new UploadArquivos().deleteAnexo(fornecedor.getAnexoSintegra(), request);
		}
		if (fornecedor.getAnexoContratoSocial() != null) {
			new UploadArquivos().deleteAnexo(fornecedor.getAnexoContratoSocial(), request);
		}
		if (fornecedor.getAnexoAditivo() != null) {
			new UploadArquivos().deleteAnexo(fornecedor.getAnexoAditivo(), request);
		}
		
		return new ResponseEntity<Fornecedor>(HttpStatus.OK);
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE, consumes = {"multipart/form-data" })
	public ResponseEntity<String> salvar(@RequestPart("files[]") List<MultipartFile> files,
			@RequestPart("fornecedor") Fornecedor fornecedor, HttpServletRequest request) {
		String path = null;
		for (MultipartFile file : files) {

			String nome = new StringHash().randomString(50) + "-" + file.getOriginalFilename();
			path = new UploadArquivos().uploadAnexo(file, nome, "upload/fornecedor/anexo", request);

			String s = file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf("."));

			if (s.equals("cartaoCnpj")) {
				fornecedor.setAnexoCartaoCnpj(path);
			}
			if (s.equals("sintegra")) {
				fornecedor.setAnexoSintegra(path);
			}
			if (s.equals("contratoSocial")) {
				fornecedor.setAnexoContratoSocial(path);
			}
			if (s.equals("aditivo")) {
				fornecedor.setAnexoAditivo(path);
			}
		}
		
		fornecedor.setStatus("CADASTRADO");
		fornecedorService.save(fornecedor);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@RequestMapping(value = "/cpfCnpj/{cpfCnpj}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> acesso(@PathVariable("cpfCnpj") String cpfCnpj) {
		String response = "";
		Fornecedor f = fornecedorService.getFornecedorByCpfCnpj(cpfCnpj);
		if (f != null) {
			response = f.getStatus();
		} else
			response = "NAO_CADASTRADO";

		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/delete/{anexo}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deleteAnexo(@PathVariable("id") Long id, @PathVariable("anexo") String anexo,
			HttpServletRequest request) {
		Fornecedor fornecedor = fornecedorService.getFornecedor(id);
		String s = anexo;
		if (s.equals("cartaoCnpj")) {		
			return new ResponseEntity<String>(new UploadArquivos().deleteAnexo(fornecedor.getAnexoCartaoCnpj(), request).toString(), HttpStatus.OK);
		}
		if (s.equals("sintegra")) {
			return new ResponseEntity<String>(new UploadArquivos().deleteAnexo(fornecedor.getAnexoSintegra(), request).toString(), HttpStatus.OK);
		}
		if (s.equals("contratoSocial")) {
			return new ResponseEntity<String>(new UploadArquivos().deleteAnexo(fornecedor.getAnexoContratoSocial(), request).toString(), HttpStatus.OK);
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@RequestMapping(value = "/alterar-senha", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fornecedor> editSenha(@RequestBody Fornecedor fornecedor) {
		String senha = new StringHash().randomString(6);
		fornecedor.setSenha(new StringHash().encode(senha));
		fornecedor.setStatus("HABILITADO");
		for(Contato contato : fornecedor.getContatos()){
			emailSender.enviarEmailAtivacao(fornecedor.getNome(), contato.getEmail(), fornecedor.getCpfCnpj(), senha);
		}
		return new ResponseEntity<Fornecedor>(fornecedorService.alterar(fornecedor), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> login(@RequestBody Fornecedor fornecedor){
		fornecedor.setSenha(new StringHash().encode(fornecedor.getSenha()));
		if(fornecedorService.login(fornecedor.getCpfCnpj(), fornecedor.getSenha()) != null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}else
		return new ResponseEntity<HttpStatus>(HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(value = "/by-cpfCnpj/{cpfCnpj}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fornecedor> getFornecedorByCpfCnpj(@PathVariable("cpfCnpj") String cpfCnpj) {
		Fornecedor f = fornecedorService.getFornecedorByCpfCnpj(cpfCnpj);
		
		return new ResponseEntity<Fornecedor>(f, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/contatos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contato>> getContatos(@PathVariable("id") Long id){
		return new ResponseEntity<List<Contato>>(contatoService.getContatoByFornecedor(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/contato/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<Contato> deleteContatos(@PathVariable("id") Long id){
		contatoService.deleta(id);
		return new ResponseEntity<Contato>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/referencias", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReferenciaComercial>> getReferencias(@PathVariable("id") Long id){
		return new ResponseEntity<List<ReferenciaComercial>>(referenciaComercialService.getReferencias(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/referenciaComercial/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<ReferenciaComercial> deleteReferencias(@PathVariable("id") Long id){
		referenciaComercialService.deleta(id);
		return new ResponseEntity<ReferenciaComercial>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/estados-atuacao", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Estado>> getEstadosAtuacao(@PathVariable("id") Long id){
		return new ResponseEntity<List<Estado>>(fornecedorService.getEstadoAtuacao(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}/estado/{idEstado}",  method = RequestMethod.DELETE)
	public ResponseEntity<Estado> deleteEstados(@PathVariable("id") Long id, @PathVariable("idEstado") Long idEstado){
		Fornecedor f = fornecedorService.getFornecedor(id);
		Estado e = new Estado();
		e.setId(idEstado);
		f.getEstadoAtuacao().remove(e);
		fornecedorService.save(f);
		
		return new ResponseEntity<Estado>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Fornecedor>> all() {
		return new ResponseEntity<List<Fornecedor>>(fornecedorService.all(), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/{id}/categorias", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoriaNivel3>> getCategorias(@PathVariable("id") Long id) {
		return new ResponseEntity<List<CategoriaNivel3>>(fornecedorService.getCategorias(id), HttpStatus.OK);

	}
	
	@RequestMapping(value="/{id}/categoria/{idCategoria}",  method = RequestMethod.DELETE)
	public ResponseEntity<CategoriaNivel3> deleteCategoria(@PathVariable("id") Long id, @PathVariable("idCategoria") Long idEstado){
		Fornecedor f = fornecedorService.getFornecedor(id);
		CategoriaNivel3 e = new CategoriaNivel3();
		e.setId(idEstado);
		f.getCategoriasNivel3().remove(e);
		fornecedorService.save(f);
		
		return new ResponseEntity<CategoriaNivel3>(HttpStatus.OK);
	}
}
