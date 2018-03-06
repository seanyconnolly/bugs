package com.suirtech.bugs.service.auth;

import com.suirtech.bugs.model.auth.Role;
import com.suirtech.bugs.model.auth.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsImpl.class);

    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
        logger.info("user here is " + user.getUsername());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        logger.info("user here is " + user.getUsername());
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
            logger.info("user here role " + role);
        }
        return authorities;
    }

    //TODO REMOVE CLEAR TEXT PASSWORDS -- {noop}[password]
    @Override
    public String getPassword() {
        System.out.println("PASS I S" + user.getPassword());
        return "{noop}" + user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
