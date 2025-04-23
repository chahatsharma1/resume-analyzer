package com.chahat.resumeanalyzer.controller;

import com.chahat.resumeanalyzer.service.ResumeAnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeAnalyzerService resumeAnalyzerService;

    private static final String UPLOAD_DIR = ("uploads/");

    @PostMapping("/upload")
    public ResponseEntity<String> uploadResume(@RequestParam("file")MultipartFile file) throws IOException {
        File newFile = new File(UPLOAD_DIR);
        if (!newFile.exists()){
            newFile.mkdir();
        }

        Path filePath = Paths.get(UPLOAD_DIR, file.getOriginalFilename());
        file.transferTo(filePath);

        return new ResponseEntity<>("File Uploaded Successfully", HttpStatus.CREATED);
    }

    @PostMapping("/analyze")
    public String analyzeResume(@RequestParam("file") String resumeFilePath, @RequestParam("jobDescription") String jobDescription) {
        return resumeAnalyzerService.analyzeResume(resumeFilePath, jobDescription);
    }
}
