package br.com.invistatech.sucessows.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class UploadArquivos {

	public String uploadAnexo(MultipartFile file, String nome, String pasta, HttpServletRequest request){
		
		String path = "";
		try {
			byte[] bytes = file.getBytes();

			// Creating the directory to store file
			String uploadsDir = "/public/"+ pasta+ "/";
            String realPathtoUploads =  request.getServletContext().getRealPath(uploadsDir);
            File dir = new File(realPathtoUploads);
			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath() + File.separator + nome);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();

			System.out.println("Server File Location=" + serverFile.getAbsolutePath());
			path = pasta +"/"+nome;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	
	return path;
}
	
	
	public Boolean deleteAnexo(String anexo, HttpServletRequest request){
		boolean delete = true;
		try{
			String uploadsDir = "/public/"+ anexo;
	        String realPathtoUploads =  request.getServletContext().getRealPath(uploadsDir);
	        File inFile = new File(realPathtoUploads);
	        delete = inFile.delete();
	        
		}catch (Exception e) {
			throw new RuntimeException();
		}
		
		return delete;
	}
	
}
