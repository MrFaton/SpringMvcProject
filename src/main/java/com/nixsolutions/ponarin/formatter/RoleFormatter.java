package com.nixsolutions.ponarin.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.nixsolutions.ponarin.dao.RoleDao;
import com.nixsolutions.ponarin.entity.Role;

@Component
public class RoleFormatter implements Formatter<Role> {
    @Autowired
    RoleDao roleDao;

    @Override
    public String print(Role role, Locale locale) {
        return role.getName();
    }

    @Override
    public Role parse(String name, Locale locale) throws ParseException {
        return roleDao.findByName(name);
    }

}
