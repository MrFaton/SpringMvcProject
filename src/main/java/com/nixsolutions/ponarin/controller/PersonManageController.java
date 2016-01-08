package com.nixsolutions.ponarin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nixsolutions.ponarin.dao.RoleDao;
import com.nixsolutions.ponarin.dao.UserDao;
import com.nixsolutions.ponarin.entity.Role;
import com.nixsolutions.ponarin.entity.User;
import com.nixsolutions.ponarin.form.UserForm;
import com.nixsolutions.ponarin.utils.UserUtils;

@Controller
public class PersonManageController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserUtils userUtils;

    @RequestMapping(value = "/admin/create", method = RequestMethod.GET)
    public ModelAndView showCreateForm() {
        ModelAndView model = new ModelAndView();

        UserForm userForm = new UserForm();

        model.addObject("userForm", userForm);
        model.setViewName("create_edit_form");

        return model;
    }

    @RequestMapping(value = "/admin/create", method = RequestMethod.POST)
    public ModelAndView create(
            @ModelAttribute("userForm") @Valid UserForm userForm,
            BindingResult result) {

        ModelAndView model = new ModelAndView();
        model.addObject("userForm", userForm);

        if (result.hasErrors()) {
            model.setViewName("create_edit_form");
            return model;
        }

        if (userUtils.isLoginExists(userForm.getLogin())) {
            result.rejectValue("login", "", "Login already exists");
            model.setViewName("create_edit_form");
            return model;
        }
        if (userUtils.isEmailExists(userForm)) {
            result.rejectValue("email", "", "Email already exists");
            model.setViewName("create_edit_form");
            return model;
        }

        Role role = roleDao.findByName(userForm.getRole());

        userDao.create(userUtils.getUserByForm(userForm, role));
        model.setViewName("redirect:/");
        return model;
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.GET)
    public ModelAndView showEditForm(HttpServletRequest request) {

        request.setAttribute("edit", true);

        User user = userDao.findByLogin(request.getParameter("person"));
        UserForm userForm = userUtils.getFormByUser(user);

        ModelAndView model = new ModelAndView();
        model.addObject("userForm", userForm);
        model.setViewName("create_edit_form");
        return model;
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    public ModelAndView edit(
            @ModelAttribute("userForm") @Valid UserForm userForm,
            BindingResult result, HttpServletRequest request) {

        request.setAttribute("edit", true);

        ModelAndView model = new ModelAndView();
        model.addObject("userForm", userForm);

        if (result.hasErrors()) {
            model.setViewName("create_edit_form");
            return model;
        }

        if (userUtils.isEmailExists(userForm)) {
            result.rejectValue("email", "", "Email already exists");
            model.setViewName("create_edit_form");
            return model;
        }

        Role role = roleDao.findByName(userForm.getRole());

        User user = userUtils.getUserByForm(userForm, role);
        User dbUser = userDao.findByLogin(user.getLogin());
        user.setId(dbUser.getId());

        userDao.update(user);

        model.setViewName("redirect:/");
        return model;
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
    public ModelAndView delete(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();

        String login = request.getParameter("person");
        User user = userDao.findByLogin(login);

        userDao.remove(user);

        model.setViewName("redirect:/");
        return model;
    }
}
