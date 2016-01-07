package com.nixsolutions.ponarin.service.impl;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nixsolutions.ponarin.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String login)
            throws UsernameNotFoundException {
        com.nixsolutions.ponarin.entity.User nativeUser = userService
                .findByLogin(login);

        if (nativeUser == null) {
            throw new UsernameNotFoundException(
                    "User with login " + login + "is not exists");
        }

        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>(0);

        String role = "ROLE_" + nativeUser.getRole().getName().toUpperCase();

        grantedAuthorities.add(new SimpleGrantedAuthority(role));

        System.out.println(role);

        return new User(nativeUser.getLogin(), nativeUser.getPassword(), true,
                true, true, true, grantedAuthorities);
    }

}
