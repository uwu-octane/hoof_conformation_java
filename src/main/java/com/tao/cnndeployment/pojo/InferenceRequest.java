package com.tao.cnndeployment.pojo;

import java.util.List;

public class InferenceRequest {
    private List<String> files;
    private String model;

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
