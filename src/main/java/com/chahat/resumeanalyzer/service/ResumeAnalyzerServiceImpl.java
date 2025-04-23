package com.chahat.resumeanalyzer.service;

import com.chahat.resumeanalyzer.request.ResumeAnalysisRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ResumeAnalyzerServiceImpl implements ResumeAnalyzerService{

    @Value("${ai.url}")
    public String aiUrl;

    @Override
    public String analyzeResume(String resumeFilePath, String jobDescription) {

        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = aiUrl + "/analyze";

        ResumeAnalysisRequest request = new ResumeAnalysisRequest(resumeFilePath, jobDescription);

        String result = restTemplate.postForObject(apiUrl, request, String.class);

        return result;
    }
}
