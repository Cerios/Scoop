package nl.cerios.scoop.web;

import nl.cerios.scoop.domain.Hall;
import nl.cerios.scoop.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class HallController {
    @Autowired
    HallService hallService_;

    @RequestMapping(value = "/hall")
    public ModelAndView hall(@RequestParam(value="id") String hallId, Model model)
    {
        Hall h = hallService_.getHall(hallId);
        model.addAttribute("hall", h);

        return new ModelAndView("hallview");
    }

    @RequestMapping(value = "/halls")
    public ModelAndView halls(Model model){
        ArrayList<Hall> halls = hallService_.getHalls();
        model.addAttribute("halls", halls);

        return new ModelAndView("hallsview");
    }
}
