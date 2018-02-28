package nl.cerios.scoop.web;

import nl.cerios.scoop.domain.Show;
import nl.cerios.scoop.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by dwhelan on 27/02/2018.
 */

@Controller
public class ShowController {

    @Autowired
    ShowService showService_;

    @RequestMapping(value = "/show" )
    public ModelAndView show(@RequestParam(value="id") String showId, Model model) {
        Show s = showService_.getShow(showId);
        model.addAttribute("show", s);
        return new ModelAndView("showview");
    }

    @RequestMapping(value = "/shows")
    public ModelAndView shows(Model model) {
        ArrayList<Show> shows = showService_.sortShowsByTime(showService_.getShowsToday());

        model.addAttribute("shows", shows);

        return new ModelAndView("showsview");
    }

//    @RequestMapping(value = "/goShow")
//    public ModelAndView goShow(@RequestParam(value="id") String showId, Model model)
//    {
//        //collect show from service
//        //Add show to session
//        //redirect to show view
//    }

}
