package com.example.apiweb.Service;

import com.example.apiweb.Entity.ImageEntity;
import com.example.apiweb.Entity.UserEntity;
import com.example.apiweb.Repo.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    private Environment env;


    @Autowired
    ImageRepo imageRepo;
    @Autowired
    UserService userService;


    public List<ImageEntity> getImageStory(int fkid){
        return imageRepo.findImageEntitiesByFkIdAndType(fkid,null);
    }
    public ImageEntity create(ImageEntity img){
        return imageRepo.save(img);
    }
    public ImageEntity getImgaeUser(int userid){
        List<ImageEntity> img = imageRepo.findImageEntitiesByFkIdAndType(userid,"avatar");
        if(img.size() > 0){
            return img.get(0);
        }
        ImageEntity imgDir = new ImageEntity();
        UserEntity user = userService.getUserbyId(userid);
        imgDir.setName(user.getName());
        imgDir.setPath("/avatar.jpg");
        imgDir.setFkId(userid);
        imgDir.setType("avatar");
        create(imgDir);
        return  imgDir;
    }

    public void save(MultipartFile file, String name) {
        Path root = Paths.get(env.getProperty("file.upload-dir")).toAbsolutePath().normalize();

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Files.copy(file.getInputStream(), root.resolve(name), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }
}
