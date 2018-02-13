package nl.cerios.scoop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dwhelan on 12/02/2018.
 */
@Controller
public class MainController {
    //Logic
    @RequestMapping(value = "/index")
    public ModelAndView index() {
        //logic.films ophalen(vandaag)
        //
        //get

        return new ModelAndView("index");
    }
    @RequestMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout() {
        return new ModelAndView("logout");
    }

    @RequestMapping("/greeting")
    public ModelAndView greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        //logic.dostuffs
        //data.getdata
        //model.addData
        //return templatename

        model.addAttribute("name", name);
        return new ModelAndView("greeter");
    }

    //Testing Functions

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    @ResponseBody
    public String version() {
        return "0.1";
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
