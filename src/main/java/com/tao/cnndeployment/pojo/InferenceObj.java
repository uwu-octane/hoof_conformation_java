package com.tao.cnndeployment.pojo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;


@Table(name="tb_inferenceobj")
@Entity
public class InferenceObj {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank()
    @Column(name = "file_name")
    private String fileName;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB", name="file_data")
    private byte[] fileData;

    @OneToMany(mappedBy = "inferenceObj", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InferenceResult> inference_results;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] file_data) {
        this.fileData = file_data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String file_name) {
        this.fileName = file_name;
    }

    public List<InferenceResult> getInference_results() {
        return inference_results;
    }

    public void setInference_results(List<InferenceResult> inference_result) {
        this.inference_results = inference_result;
    }

}
