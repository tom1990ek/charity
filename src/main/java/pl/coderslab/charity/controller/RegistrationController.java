package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.services.RoleService;
import pl.coderslab.charity.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public RegistrationController(UserService userService, RoleService roleService) {

        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping(path = "/save")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/";
    }
}
