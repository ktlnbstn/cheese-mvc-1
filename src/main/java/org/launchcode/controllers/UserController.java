package org.launchcode.controllers;

import org.launchcode.models.CheeseData;
import org.launchcode.models.User;
import org.launchcode.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "")
    public String index(Model model, User user) {
        model.addAttribute("title", "User Sign-up");
        model.addAttribute("user", user);

        return "user/index";
    }

    // Request path: /user/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user,
                      Errors errors, String verify) {

        String message = "";
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User");
            return "user/add";
        }

        if (!verify.equals(user.getPassword())) {
            model.addAttribute("name", user.getUsername());
            model.addAttribute("email", user.getEmail());
            message = "Passwords are different";
            model.addAttribute("message", message);
            return "user/add";
        } else {
            model.addAttribute("user", user);
            return "redirect:";
        }

    }


}
