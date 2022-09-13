package com.example.apiweb.Controller;


import com.example.apiweb.Base.Constants;
import com.example.apiweb.Base.Response;
import com.example.apiweb.Entity.UserEntity;
import com.example.apiweb.Service.UserService;
import com.example.apiweb.Utils.JWTTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenUtil tokenProvider;

    //Login admin
    @PostMapping("/login")
    public @ResponseBody Response authenticateAdmin(@Valid @RequestBody UserEntity user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserEntity accountLogin = userService.getUserByUsername(user.getUsername());
        String jwt = tokenProvider.generateToken(accountLogin);
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(jwt);
    }
}
