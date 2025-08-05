package com.bennieslab.portfolio.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bennieslab.portfolio.service.FileStorageService;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/thumbnail")
    public ResponseEntity<?> uploadThumbnail(@RequestParam("file") MultipartFile file) {
        try {
            String fileUrl = fileStorageService.storeFile(file);
            Map<String, String> response = new HashMap<>();
            response.put("message", "File uploaded successfully!");
            response.put("fileUrl", fileUrl);
            return ResponseEntity.ok(response);
        } catch (IOException ex) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Could not upload file: " + ex.getMessage());
            return ResponseEntity.status(500).body(errorResponse);
        }
    }
}
