package com.nixsolutions.ponarin.checker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nixsolutions.ponarin.dao.UserDao;

@Component
public class UserChecker {
    @Autowired
    private UserDao userDao;

    public boolean isLoginExists(String login) {
        if (userDao.findByLogin(login) != null) {
            return true;
        }
        return false;
    }

    public boolean isEmailExists(String email) {
        if (userDao.findByEmail(email) != null) {
            return true;
        }
        return false;
    }
}
