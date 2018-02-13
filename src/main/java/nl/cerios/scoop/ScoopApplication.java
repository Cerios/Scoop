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

//	public String films(Model model) {
//		//Get all films from db
//		//add films to model
//		//redirect to film page
//
//        ArrayList<Film> films = db.getFilms();
//        model.addAttribute("films", films);
//
//		return "filmsview";
//	}
//
//	public String film(@RequestParam(value="id", required=false, defaultValue="0") String filmId, Model model) {
//
//	    Film f = db.getFilm(filmId);
//
//	    model.addAttribute("film", f);
//
//		return "filmview";
//	}
}
