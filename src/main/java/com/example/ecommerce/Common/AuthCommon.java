package com.example.ecommerce.Common;

import com.example.ecommerce.DTOs.UserDto;
import com.example.ecommerce.Models.Roles;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommon {
    private RestTemplate restTemplate;
    public AuthCommon(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public UserDto validate(String tokenValue){
        // This will talk to the user service to verify that the user token is valid or not.
        String token = tokenValue.replace("Bearer ", "").trim();
        String url = "http://USERSELFSERVICE/users/validate/" + token;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(tokenValue);
        ResponseEntity<UserDto> response = restTemplate.exchange(url , HttpMethod.GET, new HttpEntity<>(headers), UserDto.class);
        if(!response.hasBody()){
       return null;
   }
       return  response.getBody();
    }

    public boolean hasRequiredRole(UserDto user, String requiredRole) {
        System.out.println(user.getRoles() +"ROLESSSSS");
        return user != null && user.getRoles().stream().map(Roles::getRole) .anyMatch(role ->role.equalsIgnoreCase(requiredRole) );
    }
}
