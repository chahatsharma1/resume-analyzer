package com.chahat.resumeanalyzer.request;

import lombok.Data;

@Data
public class ResumeAnalysisRequest {
    private String resumePath;
    private String jobDescription;

    public ResumeAnalysisRequest(String resumePath, String jobDescription) {
        this.resumePath = resumePath;
        this.jobDescription = jobDescription;
    }
}
