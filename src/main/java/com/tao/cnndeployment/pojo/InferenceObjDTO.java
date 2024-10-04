package com.tao.cnndeployment.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class InferenceObjDTO {
    @NotNull
    @NotBlank()
    private String fileName;
    private byte[] fileData;


    public InferenceObjDTO() {}

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

}
