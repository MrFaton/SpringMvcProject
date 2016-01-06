package com.nixsolutions.ponarin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
//@RequestMapping("/")
public class RoleController {
    @RequestMapping(method = RequestMethod.GET)
    public String greeting(ModelMap model) {
        return "role";
    }
}
