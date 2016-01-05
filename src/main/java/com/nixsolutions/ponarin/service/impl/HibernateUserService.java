package com.nixsolutions.ponarin.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nixsolutions.ponarin.dao.RoleDao;
import com.nixsolutions.ponarin.dao.UserDao;
import com.nixsolutions.ponarin.entity.Role;
import com.nixsolutions.ponarin.entity.User;
import com.nixsolutions.ponarin.service.UserService;
import com.nixsolutions.ponarin.utils.UserUtils;

@Service
public class HibernateUserService implements UserService {
    private static final Logger logger = LoggerFactory
            .getLogger(HibernateUserService.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserUtils userUtils;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void create(User user) {
        logger.trace("create user");
        checkLogin(user.getLogin());
        checkEmail(user.getEmail());
        userDao.create(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void create(Map<String, String> userForm) {
        logger.trace("create user by user form");
        checkLogin(userForm.get("login"));
        checkEmail(userForm.get("email"));
        Role role = roleDao.findByName(userForm.get("role"));
        User user = userUtils.getUserByForm(userForm, role);
        userDao.create(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void update(User user) {
        logger.trace("update user");
        User loadedUser = userDao.findByLogin(user.getLogin());
        user.setId(loadedUser.getId());

        if (loadedUser.getEmail().equalsIgnoreCase(user.getEmail())) {
            userDao.update(user);
        } else {
            checkEmail(user.getEmail());
            userDao.update(user);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void update(Map<String, String> userForm) {
        logger.trace("update user by user form");
        Role role = roleDao.findByName(userForm.get("role"));
        User user = userUtils.getUserByForm(userForm, role);

        User loadedUser = userDao.findByLogin(user.getLogin());
        user.setId(loadedUser.getId());

        if (loadedUser.getEmail().equalsIgnoreCase(user.getEmail())) {
            userDao.update(user);
        } else {
            checkEmail(user.getEmail());
            userDao.update(user);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void remove(User user) {
        logger.trace("remove user");
        userDao.remove(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void remove(String login) {
        logger.trace("remove user by login: " + login);
        if (login == null || login.length() == 0) {
            throw new IllegalArgumentException("Login is blank");
        }
        User user = userDao.findByLogin(login);
        if (user != null) {
            userDao.remove(user);
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<User> findAll() {
        logger.trace("find all users");
        return userDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User findByLogin(String login) {
        logger.trace("find user by login: " + login);
        if (login == null || login.length() == 0) {
            throw new IllegalArgumentException("Login is blank");
        }
        return userDao.findByLogin(login);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User findByEmail(String email) {
        logger.trace("find user by email: " + email);
        if (email == null || email.length() == 0) {
            throw new IllegalArgumentException("Login is blank");
        }
        return userDao.findByEmail(email);
    }

    private void checkLogin(String login) {
        if (userDao.findByLogin(login) != null) {
            String msg = "User with login '" + login + "' already exists";
            logger.debug(msg);
            throw new IllegalArgumentException(msg);
        }
    }

    private void checkEmail(String email) {
        if (userDao.findByEmail(email) != null) {
            String msg = "User with email '" + email + "' already exists";
            logger.debug(msg);
            throw new IllegalArgumentException(msg);
        }
    }

}
