package com.example.ecommerce.Common;

import com.example.ecommerce.DTOs.UserDto;
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
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(tokenValue);
//        System.out.println(tokenValue + " VALUE");
//        ResponseEntity<UserDto> response = restTemplate.getForEntity("http://USERSELFSERVICE/users/validate/" + tokenValue, UserDto.class);
        ResponseEntity<UserDto> response = restTemplate.exchange("http://USERSELFSERVICE/users/validate/" , HttpMethod.GET, new HttpEntity<>(headers), UserDto.class);
//
        //        System.out.println(response.getBody());
        if(!response.hasBody()){
       return null;
   }
       return  response.getBody();
    }

    public boolean hasRequiredRole(UserDto user, String role) {
        return user != null && user.getRole().contains(role);
    }
}
