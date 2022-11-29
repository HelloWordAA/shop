package com.example.demo.Upload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * yzw
 * 2022/11/25
 */
@Service
public class FileServiceImpl implements FileService {

    @Value("${tempFilePath}")
    private String tempFilePath;

    @Override
    public Long upload(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return null;
        }
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1);
        int fileSize = (int) file.getSize();
//        String date = formatDate("yyyy-MM-dd",System.currentTimeMillis());
        String path = tempFilePath+"/"+fileName;
        String filePath = fileName+ UUID.randomUUID();

        File file1 = new File(path);
        if (!file1.getParentFile().exists()){
            file1.getParentFile().mkdirs();
        }
        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path));
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();
//            File files = new File();
//            files.setName(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void download(Long id, HttpServletRequest req, HttpServletResponse res) {

    }
}
