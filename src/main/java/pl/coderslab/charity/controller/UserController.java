package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.services.UserService;

@Controller
@RequestMapping("/adminPanel")
public class UserController {
    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping(path = "/allUsers")
    public String findAllUsers(Model model) {
        model.addAttribute("allusers", userService.findAllUsers());
        return "admin_users";
    }

    @GetMapping(path = "/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("useredit", userService.findUserById(id));
        return "admin_userEdit";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteUser(@ModelAttribute User user) {
        userService.deleteUser(user);
        return "redirect:/adminPanel/allUsers";

    }

}
