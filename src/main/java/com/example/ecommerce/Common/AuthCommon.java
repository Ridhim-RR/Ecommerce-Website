package com.example.ecommerce.Common;

import com.example.ecommerce.DTOs.UserDto;
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
        //        This will talk to the user service to verify that the user token is valid or not.
        System.out.println(tokenValue + " VALUE");
        ResponseEntity<UserDto> response = restTemplate.getForEntity("http://USERSELFSERVICE/users/validate/" + tokenValue, UserDto.class);
        System.out.println(response.getBody());
        if(!response.hasBody()){
       return null;
   }
       return  response.getBody();
    }
}
