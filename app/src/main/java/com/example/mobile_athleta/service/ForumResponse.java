package com.example.mobile_athleta.service;

import com.example.mobile_athleta.models.Forum;

import java.util.List;

public class ForumResponse {
    private boolean responseSucessfull;
    private String description;
    private List<Forum> forums;
    private String aditionalInformation;

    public ForumResponse(boolean responseSucessfull, String description, List<Forum> object, String aditionalInformation) {
        this.responseSucessfull = responseSucessfull;
        this.description = description;
        this.forums = object;
        this.aditionalInformation = aditionalInformation;
    }

    public boolean isResponseSucessfull() {
        return responseSucessfull;
    }

    public String getDescription() {
        return description;
    }

    public List<Forum> getForums() {
        return forums;
    }

    public String getAditionalInformation() {
        return aditionalInformation;
    }
}
