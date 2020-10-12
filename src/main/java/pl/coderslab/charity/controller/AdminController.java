package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/adminPanel")
public class AdminController {



    @GetMapping
    public String displayPanel() {
        return "admin_panel";
    }



}
