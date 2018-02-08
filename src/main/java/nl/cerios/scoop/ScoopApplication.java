package nl.cerios.scoop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.ArrayList;
import java.util.Locale;

@SpringBootApplication
@EnableAutoConfiguration
@Controller
public class ScoopApplication {

	static FilmDB db;

	//Main
	public static void main(String[] args) {
		SpringApplication.run(ScoopApplication.class, args);
		db = new FilmDB();
	}

	//Logic
    @RequestMapping(value = "/index")
    public String index() {
		//logic.films ophalen(vandaag)
		//
		//get

		return "index";
	}

	@RequestMapping(value = "/films")
	public String films(Model model) {
		//Get all films from db
		//add films to model
		//redirect to film page

        ArrayList<Film> films = db.getFilms();
        model.addAttribute("films", films);

		return "filmsview";
	}

	@RequestMapping(value ="/film")
	public String film(@RequestParam(value="id", required=false, defaultValue="0") String filmId, Model model) {

	    Film f = db.getFilm(filmId);

	    model.addAttribute("film", f);

		return "filmview";
	}

	@RequestMapping(value = "/login")
	public String login() {
	    return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout() {
	    return "logout";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        //logic.dostuff
		//data.getdata
		//model.addData
		//return templatename

		model.addAttribute("name", name);
        return "greeter";
    }

	//Testing Functions
	@RequestMapping(value = "/templateloc", method = RequestMethod.GET)
	@ResponseBody
	public String locateTemplates() {
		return "1";
	}

	@RequestMapping(value = "/version", method = RequestMethod.GET)
	@ResponseBody
	public String version() {
		return "0";
	}

	@GetMapping(value = "/test/GET")
	@ResponseBody
	public String getResponse() {
		return "You GETted the server!";
	}

	@PostMapping(value = "/test/POST")
	@ResponseBody
	public String postResponse() {
		return "You POSTed the server!";
	}
}
