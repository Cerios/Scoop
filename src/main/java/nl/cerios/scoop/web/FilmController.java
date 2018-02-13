package nl.cerios.scoop.web;

import nl.cerios.scoop.domain.Film;
import nl.cerios.scoop.service.FilmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Created by dwhelan on 09/02/2018.
 */

@Controller
public class FilmController {

    @Autowired
    FilmService filmService_;

    @RequestMapping("/films")
    public ModelAndView films(Model model) {
        //Get film or null
        ArrayList<Film> films = filmService_.getFilms();
        model.addAttribute("films", films);

        return new ModelAndView("filmsview");
    }

    @RequestMapping("/film")
    public ModelAndView film(@RequestParam(value="id") String filmId, Model model) {
        Film f = filmService_.getFilm(filmId);
        model.addAttribute("film", f);

        return new ModelAndView("filmview");
    }

    @RequestMapping("/index")
    public ModelAndView indexPage(Model model) {

        ArrayList<Film> films = filmService_.getFilms();
        model.addAttribute("films", films);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-uuuu");

        model.addAttribute("time", java.time.LocalDateTime.now().format(df));

        return new ModelAndView("index");
    }
}
