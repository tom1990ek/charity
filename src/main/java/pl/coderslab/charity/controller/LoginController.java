package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

//    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
//    public String login() {
//        return "login";
//    }


    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping("/")
    public ModelAndView userDashboard() {
        return new ModelAndView("index");
    }

    @RequestMapping("/adminPanel")
    public ModelAndView adminDashboard() {
        return new ModelAndView("admin_panel");
    }

}
