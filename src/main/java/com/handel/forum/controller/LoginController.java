package com.handel.forum.controller;


import com.handel.forum.model.ForumUsers;
import com.handel.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.addObject("edit", false);
//        modelAndView.addObject("availableTeams", teamService.findAllTeams());
        modelAndView.addObject("users", new ForumUsers());

        modelAndView.setViewName("registration");
        return modelAndView;
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid ForumUsers users, BindingResult bindingResult, ModelAndView modelAndView) {
        modelAndView.addObject("edit", false);

        if (userService.findUserByEmail(users.getEmail()) != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "The email address is in use already!");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("errorMessage", "Fill in all fields!!");
            modelAndView.setViewName("registration");
        } else {
//            users.setRoles("USER");
            userService.saveNewUser(users);
            modelAndView.addObject("successMessage", "User has been registered!");
            modelAndView.addObject("users", new ForumUsers());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }




}
