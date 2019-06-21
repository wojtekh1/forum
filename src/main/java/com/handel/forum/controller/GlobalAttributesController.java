package com.handel.forum.controller;


import com.handel.forum.model.UserType;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SessionAttributes({"allItems", "allCategories", "allPrios", "states"})
@ControllerAdvice
public class GlobalAttributesController {


    @ModelAttribute("userTypes")
    public List<UserType> getUserTypes() {
       return Stream.of(new UserType(1, "ADMIN "), new UserType(2, "USER"))
                .collect(Collectors.toList());
    }
    @ModelAttribute("userType")
    public List<UserType> getUserType() {
        return Stream.of(new UserType(2, "USER"))
                .collect(Collectors.toList());
    }

}
