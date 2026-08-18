package com.example.demo.service;

import com.example.demo.dto.FileResponse;
import com.example.demo.entity.FileDocument;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    FileResponse uploadFile(MultipartFile file) throws IOException;

    List<FileResponse> uploadMultipleFiles(MultipartFile[] files) throws IOException;

    List<FileResponse> getAllFiles();

    FileDocument downloadFile(Long id);

    void deleteFile(Long id);


}
