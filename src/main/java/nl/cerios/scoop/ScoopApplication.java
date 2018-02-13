package nl.cerios.scoop;

import nl.cerios.scoop.service.FilmService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ScoopApplication extends SpringBootServletInitializer {

	static FilmService db;

	//Main
	public static void main(String[] args) {
		SpringApplication.run(ScoopApplication.class, args);
		db = new FilmService();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ScoopApplication.class);
	}
}
