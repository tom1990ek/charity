package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/admins")
public class AllAdminController {

    private UserService userService;

    public AllAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayAdminsCrudPage() {
        return "admin_allAdmins";
    }

    @ModelAttribute("admins")
    public List<User> getAllAdmins() {
        return userService.findAllAdmins();
    }

}

