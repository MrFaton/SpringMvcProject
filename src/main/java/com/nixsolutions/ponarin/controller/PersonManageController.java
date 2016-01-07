package com.nixsolutions.ponarin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nixsolutions.ponarin.checker.UserChecker;
import com.nixsolutions.ponarin.dao.UserDao;
import com.nixsolutions.ponarin.entity.User;

@Controller
public class PersonManageController {
    @Autowired
    private UserDao userDao;

    private UserChecker userChecker = new UserChecker();
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registrationForm";
    }
    

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUserAccount(@ModelAttribute("user") @Valid User user,
            BindingResult result, ModelMap model) {
        
        model.addAttribute("user", user);
        if (result.hasErrors()) {
            return "registrationForm";
        }
        if (userChecker.isLoginExists(user.getLogin())) {
            result.rejectValue("login", "message.regError");
        }
        if (userChecker.isEmailExists(user.getEmail())) {
            result.rejectValue("email", "message.regError");
        }
        userDao.create(user);
        return "registrationFormSuccess";
    }
}
