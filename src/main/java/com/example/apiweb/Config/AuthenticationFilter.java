package com.example.apiweb.Config;

import com.example.apiweb.Service.UserService;
import com.example.apiweb.Utils.JWTTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.ServletException;
import java.io.IOException;

public class AuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    JWTTokenUtil jwtTokenUtil;
    @Autowired
    UserService userService;

    @Override
    protected void doFilterInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain filterChain) throws ServletException, IOException {
        try{

            String token = request.getHeader("Authorization");
            if(jwtTokenUtil.validateToken(token)){
                String username = jwtTokenUtil.getDataToke(token);
                if(username != null){
                    User user = (User) userService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error dofiller");
        }
        filterChain.doFilter(request,response);
    }
}
