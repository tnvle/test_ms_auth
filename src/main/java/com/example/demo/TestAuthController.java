package com.example.demo;

import ea.sof.shared.models.Auth;
import ea.sof.shared.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class TestAuthController {

    @Autowired
    MsAuth msAuth;

    @GetMapping("/test-validate-token")
    public ResponseEntity<?> test(@RequestHeader(name="Authorization", required = false) String token){
        try {
            ResponseEntity<Response> responseEntity = msAuth.validateToken(token);

            return responseEntity;
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }


    }

    @PostMapping("/test-add-auth")
    public ResponseEntity<?> testAddAuth(@RequestBody Auth auth){
        ResponseEntity responseEntity = msAuth.addAuth(auth);
        return responseEntity;

    }
}
