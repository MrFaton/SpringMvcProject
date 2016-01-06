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

        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>(0);

        grantedAuthorities.add(
                new SimpleGrantedAuthority(nativeUser.getRole().getName()));
        
        System.out.println(nativeUser.getRole().getName());

        return new User(nativeUser.getLogin(), nativeUser.getPassword(), true,
                true, true, true, grantedAuthorities);
    }

}
