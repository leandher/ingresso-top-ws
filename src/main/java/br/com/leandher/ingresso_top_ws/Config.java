package br.com.leandher.ingresso_top_ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@SpringBootApplication
public class Config extends SpringBootServletInitializer{

	public static void main(String[] args) {
		 SpringApplication.run(Config.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Config.class);
	}
	 
	@Bean
	public Module datatypeHibernateModule() {
		 Hibernate4Module hibernate4Module = new Hibernate4Module();
		 hibernate4Module.configure(Hibernate4Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS, true);
		 return hibernate4Module;
	}
	 
}
