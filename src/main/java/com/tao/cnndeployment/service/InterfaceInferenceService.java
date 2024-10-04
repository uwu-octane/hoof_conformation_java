package com.tao.cnndeployment.service;

import com.tao.cnndeployment.pojo.InferenceObj;
import com.tao.cnndeployment.pojo.InferenceObjDTO;
import com.tao.cnndeployment.pojo.InferenceResult;
import com.tao.cnndeployment.pojo.ModelType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface InterfaceInferenceService {
    InferenceObj add(InferenceObjDTO inference_obj_dto);

    InferenceObj get_obj(Integer obj_id);

    InferenceObj edit(InferenceObj inference_obj);

    void delete(Integer obj_id);

    List<Map<String, String>> run_inference(List<String> files, String modelType);

    List<Integer> findIdsByFileName(List<String> files);
}
