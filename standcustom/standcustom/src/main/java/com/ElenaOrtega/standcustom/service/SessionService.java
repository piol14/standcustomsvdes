package com.ElenaOrtega.standcustom.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ElenaOrtega.standcustom.bean.UserBean;
import com.ElenaOrtega.standcustom.entity.UserEntity;
import com.ElenaOrtega.standcustom.exception.ResourceNotFoundException;
import com.ElenaOrtega.standcustom.exception.UnauthorizedException;
import com.ElenaOrtega.standcustom.helper.JWTHelper;
import com.ElenaOrtega.standcustom.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;




@Service
public class SessionService {

@Autowired
UserRepository oUserRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    public String login(UserBean oUserBean) {
        String strUsername = oUserBean.getUsername();

        oUserRepository.findByUsernameAndPassword(strUsername,oUserBean.getPassword())
                .orElseThrow(() -> new ResourceNotFoundException("Wrong User"));
        return JWTHelper.generateJWT(oUserBean.getUsername());
    }
 public String getSessionUsername() {        
    Object usernameAttribute = oHttpServletRequest.getAttribute("username");
    if (usernameAttribute instanceof String) {
        return usernameAttribute.toString();
    } else {
        // Add a log statement for debugging
        System.out.println("Attribute 'username' is not a String or is null");
        return null;
    }
}

    public UserEntity getSessionUser() {
        if (this.getSessionUsername() != null) {
            return oUserRepository.findByUsername(this.getSessionUsername()).orElse(null);    
        } else {
            return null;
        }
    }

    public Boolean isSessionActive() {
        if (this.getSessionUsername() != null) {
            return oUserRepository.findByUsername(this.getSessionUsername()).isPresent();
        } else {
            return false;
        }
    }

    public Boolean isAdmin() {
        if (this.getSessionUsername() != null) {
            UserEntity oUserEntityInSession = oUserRepository.findByUsername(this.getSessionUsername())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));
            return Boolean.FALSE.equals(oUserEntityInSession.getRole());
        } else {
            return false;
        }
    }

    public Boolean isUser() {
        if (this.getSessionUsername() != null) {
            UserEntity oUserEntityInSession = oUserRepository.findByUsername(this.getSessionUsername())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));
            return Boolean.TRUE.equals(oUserEntityInSession.getRole());
        } else {
            return false;
        }
    }

    public void onlyAdmins() {
        if (!this.isAdmin()) {
            throw new UnauthorizedException("Only admins can do this");
        }
    }

    public void onlyUsers() {
        if (!this.isUser()) {
            throw new UnauthorizedException("Only users can do this");
        }
    }

    public void onlyAdminsOrUsers() {
        if (!this.isSessionActive()) {
            throw new UnauthorizedException("Only admins or users can do this");
        }
    }

    public void onlyUsersWithIisOwnData(Long id_user) {
        if (!this.isUser()) {
            throw new UnauthorizedException("Only users can do this");
        }
        if (!this.getSessionUser().getId().equals(id_user)) {
            throw new UnauthorizedException("Only users can do this");
        }
    }

    public void onlyAdminsOrUsersWithIisOwnData(Long id_user) {
        if (this.isSessionActive()) {
            if (!this.isAdmin()) {
                if (!this.isUser()) {
                    throw new UnauthorizedException("Only admins or users can do this");
                } else {
                    if (!this.getSessionUser().getId().equals(id_user)) {
                        throw new UnauthorizedException("Only admins or users with its own data can do this");
                    }
                }
            }
        } else {
            throw new UnauthorizedException("Only admins or users can do this");
        }
    }

}
