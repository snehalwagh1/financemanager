package com.iitp.projects.financemanager.security.authentication;

import com.iitp.projects.financemanager.model.UserData;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
public class UserAuthentication implements Authentication {
    UserData userData;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return userData.getPassword();
    }

    @Override
    public Object getDetails() {
        return userData.getFirstName();
    }

    @Override
    public Object getPrincipal() {
        return userData.getUsername();
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return userData.getUsername();
    }
}
