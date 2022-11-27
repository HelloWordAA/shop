package com.example.demo.Upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * yzw
 * 2022/11/25
 */
@Controller
public class UploadController {
    @Autowired
    private FileService fileServiceImpl;
    @PostMapping("uplaod")
    public Long upload(@RequestParam MultipartFile file){
        return fileServiceImpl.upload(file);
    }

    @GetMapping("download/{id}")
    public void download(@PathVariable Long id, HttpServletRequest req , HttpServletResponse res){
        fileServiceImpl.download(id, req, res);
    }

}
