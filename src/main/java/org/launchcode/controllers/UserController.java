package org.launchcode.controllers;

import org.launchcode.models.User;
import org.launchcode.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "")
    public String index(Model model, User user) {
        model.addAttribute("title", "User Sign-up");
        model.addAttribute("user", user);

        return "user/index";
    }

    // Request path: /user/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAdd(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAdd(Model model, @ModelAttribute @Valid User user,
                             Errors errors, String verify) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User");
            model.addAttribute(user);
            return "user/add";
        }

        if (user.getPassword() == null || verify == null) {
            model.addAttribute("title", "Add User");
            model.addAttribute("message", "Password required");
            user.setPassword("");
            return "user/add";
        }

        if (!verify.equals(user.getPassword())) {
            model.addAttribute("name", user.getUsername());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("message2", "Passwords do not match.");
            user.setPassword("");
            return "user/add";
        } else {
            model.addAttribute("user", user);
            return "redirect:";
        }

    }

}
