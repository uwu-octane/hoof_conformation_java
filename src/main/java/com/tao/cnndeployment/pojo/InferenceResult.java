package com.tao.cnndeployment.pojo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table
@Entity
public class InferenceResult {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="inferenceObj_id")
    private InferenceObj inferenceObj;

    private String file_name;

    private String model_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InferenceObj getInferenceObj() {
        return inferenceObj;
    }

    public void setInferenceObj(InferenceObj inferenceObj) {
        this.inferenceObj = inferenceObj;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public byte[] getPrediction_mask() {
        return prediction_mask;
    }

    public void setPrediction_mask(byte[] prediction_mask) {
        this.prediction_mask = prediction_mask;
    }

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] prediction_mask;


    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] conformation_result;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] contour_result;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] points_sort_result;


    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public byte[] getConformation_result() {
        return conformation_result;
    }

    public void setConformation_result(byte[] conformation_result) {
        this.conformation_result = conformation_result;
    }

    public byte[] getContour_result() {
        return contour_result;
    }

    public void setContour_result(byte[] contour_result) {
        this.contour_result = contour_result;
    }

    public byte[] getPoints_sort_result() {
        return points_sort_result;
    }

    public void setPoints_sort_result(byte[] points_sort_result) {
        this.points_sort_result = points_sort_result;
    }

    private float dorsal_hoof_wall_length;
    private float weight_bearing_length;
    private float heel_height;
    private float dorsal_coronary_band_height;

    private float dorsal_hoof_wall_angle;
    private float coronary_band_angle;
    private float heel_angle;

    private float inference_time;
    private LocalDate inference_date;

    public byte[] getPrediction_mask_output_path() {
        return prediction_mask;
    }

    public void setPrediction_mask_output_path(byte[] prediction_mask) {
        this.prediction_mask = prediction_mask;
    }

    public float getInference_time() {
        return inference_time;
    }

    public void setInference_time(float inference_time) {
        this.inference_time = inference_time;
    }

    public LocalDate getInference_date() {
        return inference_date;
    }

      /*  public String get_formated_date(){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return inference_date.format(formatter);
        }*/

    public void setInference_date(LocalDate inference_date) {
        this.inference_date = inference_date;
    }


    public float getDorsal_hoof_wall_length() {
        return dorsal_hoof_wall_length;
    }

    public void setDorsal_hoof_wall_length(float dorsal_hoof_wall_length) {
        this.dorsal_hoof_wall_length = dorsal_hoof_wall_length;
    }

    public float getWeight_bearing_length() {
        return weight_bearing_length;
    }

    public void setWeight_bearing_length(float weight_bearing_length) {
        this.weight_bearing_length = weight_bearing_length;
    }

    public float getHeel_height() {
        return heel_height;
    }

    public void setHeel_height(float heel_height) {
        this.heel_height = heel_height;
    }

    public float getDorsal_coronary_band_height() {
        return dorsal_coronary_band_height;
    }

    public void setDorsal_coronary_band_height(float dorsal_coronary_band_height) {
        this.dorsal_coronary_band_height = dorsal_coronary_band_height;
    }

    public float getDorsal_hoof_wall_angle() {
        return dorsal_hoof_wall_angle;
    }

    public void setDorsal_hoof_wall_angle(float dorsal_hoof_wall_angle) {
        this.dorsal_hoof_wall_angle = dorsal_hoof_wall_angle;
    }

    public float getCoronary_band_angle() {
        return coronary_band_angle;
    }

    public void setCoronary_band_angle(float coronary_band_angle) {
        this.coronary_band_angle = coronary_band_angle;
    }

    public float getHeel_angle() {
        return heel_angle;
    }

    public void setHeel_angle(float heel_angle) {
        this.heel_angle = heel_angle;
    }
}

