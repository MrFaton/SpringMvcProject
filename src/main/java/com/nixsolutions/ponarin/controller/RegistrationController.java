package com.nixsolutions.ponarin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nixsolutions.ponarin.dao.RoleDao;
import com.nixsolutions.ponarin.dao.UserDao;
import com.nixsolutions.ponarin.entity.Role;
import com.nixsolutions.ponarin.entity.User;
import com.nixsolutions.ponarin.form.UserForm;
import com.nixsolutions.ponarin.utils.UserUtils;

@Controller
public class RegistrationController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserUtils userUtils;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(ModelMap model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "registration_form";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUserAccount(
            @ModelAttribute("userForm") @Valid UserForm userForm,
            BindingResult result, ModelMap model) {

        model.addAttribute("userForm", userForm);
        if (result.hasErrors()) {
            return "registration_form";
        }

        if (userUtils.isLoginExists(userForm.getLogin())) {
            result.rejectValue("login", "", "Login already exists");
            return "registration_form";
        }
        if (userUtils.isEmailExists(userForm)) {
            result.rejectValue("email", "", "Email already exists");
            return "registration_form";
        }

        Role role = roleDao.findByName("User");

        userDao.create(userUtils.getUserByForm(userForm, role));
        return "registration_form_success";
    }
}
