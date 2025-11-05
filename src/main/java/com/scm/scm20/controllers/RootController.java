package com.scm.scm20.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.scm.scm20.entities.User;
import com.scm.scm20.helpers.Helper;
import com.scm.scm20.services.UserService;

@ControllerAdvice
public class RootController {

    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

     @ModelAttribute
    public void addLoggedInUserInformation(Model modal,Authentication authentication){
        if (authentication==null) {
            return;
        }
        System.out.println("Adding logged in user information to the modal");

        String username=  Helper.getEmailOfLoggedLnUser(authentication);

      
        logger.info("User profile in: {}",username);
        //database se data ko fatch :get user from db:email,name,address
       User user= userService.getUserByEmail(username);
       
       System.out.println(user);
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        modal.addAttribute("loggedInUser",user);
     
         
    }
}
