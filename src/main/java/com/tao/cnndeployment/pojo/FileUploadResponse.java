package com.tao.cnndeployment.pojo;

public class FileUploadResponse {
    private String fileName;
    private String status;

    public FileUploadResponse(String fileName, String status) {
        this.fileName = fileName;
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
