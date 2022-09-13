package com.example.apiweb.Controller;

import com.example.apiweb.Base.Constants;
import com.example.apiweb.Base.Response;
import com.example.apiweb.Entity.ImageEntity;
import com.example.apiweb.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/img")
public class ImageController {
    @Autowired
    ImageService imageService;
    @PostMapping("/upload")
    public @ResponseBody Response Post(@RequestParam("file") MultipartFile file,@RequestParam("name")String name){
        try {
            imageService.save(file, name);
            return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData("done");
        }catch (Exception ex){
            return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(ex);

        }

    }
    @PostMapping("/create")
    public @ResponseBody Response Create(@RequestBody  ImageEntity b){
        imageService.create(b);
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData("done");

    }

}
