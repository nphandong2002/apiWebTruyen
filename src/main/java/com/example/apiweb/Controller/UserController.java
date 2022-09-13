package com.example.apiweb.Controller;

import com.example.apiweb.Base.Constants;
import com.example.apiweb.Base.Response;
import com.example.apiweb.DTO.UserDTO;
import com.example.apiweb.Entity.ImageEntity;
import com.example.apiweb.Entity.UserEntity;
import com.example.apiweb.Service.ImageService;
import com.example.apiweb.Service.UserService;
import com.example.apiweb.Utils.JWTTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ImageService imageService;
    @Autowired
    JWTTokenUtil tokenProvider;

    @PostMapping("/user/{id}")
    public @ResponseBody Response Post(@PathVariable("id") int id, @RequestHeader(HttpHeaders.AUTHORIZATION) String  jwt){
        UserEntity user = new UserEntity();
        if(id == 0){
            String username = tokenProvider.getDataToke(jwt);
            user = userService.getUserByUsername(username);
        }else{
            user = userService.getUserbyId(id);
        }
        if(user == null){
            return Response.success().withData("user no found");
        }else{
            ImageEntity img = imageService.getImgaeUser(user.getId());
            UserDTO userDto = new UserDTO();
            userDto.setId(user.getId());
            userDto.setRoleId(user.getRoleId());
            userDto.setName(user.getName());
            userDto.setExp(user.getExp());
            userDto.setUrl_avatar(img != null ? img.getPath() :  "");
            userDto.setGender(user.getGender());
//            userDto.setNavbar(navbarService.getNavbar(userDto.getRoleId()));
            return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(userDto);
        }
    }
}
