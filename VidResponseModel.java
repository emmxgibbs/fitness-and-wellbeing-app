package com.team4.fitness_and_wellbeing.model;

import org.springframework.web.multipart.MultipartFile;

public class VidResponseModel {
    MultipartFile file;
    String description;

    public VidResponseModel(MultipartFile file, String description) {
        this.file = file;
        this.description = description;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
