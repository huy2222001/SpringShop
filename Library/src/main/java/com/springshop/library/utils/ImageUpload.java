package com.springshop.library.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.cert.TrustAnchor;

@Component
public class ImageUpload {
    //image processing
    private final String UPLOAD_FOLDER = "G:\\SpringProjectIntelij\\SpringShop\\Admin\\src\\main\\resources\\static\\img\\image-product";

    public boolean uploadImage(MultipartFile file) {
        boolean isUpload = false;
        try {
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_FOLDER + File.separator + file.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
            isUpload = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpload;
    }
    public boolean checkExist(MultipartFile multipartFile){
        boolean isExist = false;
        try {
            File file = new File(UPLOAD_FOLDER +"\\" + multipartFile.getOriginalFilename());
            isExist = file.exists();
        }catch (Exception e){
            e.printStackTrace();
        }
        return isExist;
    }
}
