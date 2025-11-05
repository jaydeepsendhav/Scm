package com.scm.scm20.helpers;


import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import org.springframework.security.oauth2.core.user.OAuth2User;

public class Helper {
    @SuppressWarnings("null")
    public static String getEmailOfLoggedLnUser(Authentication authentication){

       
        //agar email id password se login kiya hai to: email kaise nikalenge
        if(authentication instanceof OAuth2AuthenticationToken){

           var aOAuth2AuthenticationToken=(OAuth2AuthenticationToken)authentication;
           var clientId=aOAuth2AuthenticationToken.getAuthorizedClientRegistrationId();

           var oauth2User =(OAuth2User)authentication.getPrincipal();
           String username="";

           if (clientId.equalsIgnoreCase("google")) {

            //sing with google


            System.out.println("Getting email from google client");
           username= oauth2User.getAttribute("email").toString();
            
           }
           else if (clientId.equalsIgnoreCase("github")) {
            
             //sign with Github
             System.out.println("Getting email from github");
             username=oauth2User.getAttribute("email")!=null ? oauth2User.getAttribute("email").toString() :oauth2User.getAttribute("login").toString() + "@gmail.com"; 
           }
            

            //sign with facebook
           return username;
           
        }else{
            System.out.println("Getting data from local data base");
            return authentication.getName();
        }

      
        


    }

    // public static String getLinkForEmailVerification(String emailToken){

    //     String link="http://localhost:8081/auth/verify-email?token=" + emailToken;

    //     return link;
    // }
}

