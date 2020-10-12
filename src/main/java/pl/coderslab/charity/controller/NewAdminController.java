package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/registeradmin")
public class NewAdminController {

    private UserService userService;

    public NewAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String createAdmin(Model model) {
        model.addAttribute("admin", new User());
        return "admin_newAdminAdd";
    }

    @PostMapping(path = "/saveadmin")
    public String saveAdmin(@ModelAttribute("admin") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin_newAdminAdd";
        }
        userService.saveAdmin(user);
        return "redirect:/admins";
    }
}
