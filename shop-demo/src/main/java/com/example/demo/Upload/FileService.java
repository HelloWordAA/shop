package com.example.demo.Upload;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * yzw
 * 2022/11/25
 */
public interface FileService {
    public Long upload(MultipartFile file);

    void download(Long id, HttpServletRequest req, HttpServletResponse res);
}
