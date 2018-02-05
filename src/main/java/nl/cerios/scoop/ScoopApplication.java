package nl.cerios.scoop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@EnableAutoConfiguration
@Controller
public class ScoopApplication {
	//Main
	public static void main(String[] args) {
		SpringApplication.run(ScoopApplication.class, args);
	}

    @RequestMapping(value = "/index")
    public String index() { return "index"; }

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
        model.addAttribute("name", name);
        return "greeting";
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
