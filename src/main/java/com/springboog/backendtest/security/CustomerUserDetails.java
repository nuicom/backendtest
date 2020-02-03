package com.springboog.backendtest.security;

import com.springboog.backendtest.domain.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


public class CustomerUserDetails implements UserDetails {

    private String password;
    private int loginId;
    private String name;
    private Collection<? extends GrantedAuthority> authorities = Collections.emptyList();

    public CustomerUserDetails(Account account) {
        this.password = account.getPassword();
        this.loginId = account.getId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    @Override
    public String toString() {
        return "CustomerUserDetails{" +
                "password='" + password + '\'' +
                ", loginId=" + loginId +
                ", name='" + name + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
