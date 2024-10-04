package com.tao.cnndeployment.service;

import com.tao.cnndeployment.config.CNNModelConfig;
import com.tao.cnndeployment.pojo.InferenceObj;
import com.tao.cnndeployment.pojo.InferenceObjDTO;
import com.tao.cnndeployment.repository.InferenceObjRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class InferenceService implements InterfaceInferenceService{

    private InferenceObjRepository InferenceObjRepository;

    private CNNModelConfig cnnModelConfig;

    private PythonService pythonService;

    @Autowired
    public InferenceService(InferenceObjRepository inferenceObjRepository,
                            CNNModelConfig cnnModelConfig,
                            PythonService pythonService) {
        this.InferenceObjRepository = inferenceObjRepository;
        this.cnnModelConfig = cnnModelConfig;
        this.pythonService = pythonService;
    }

    @Override
    public InferenceObj add(InferenceObjDTO inference_obj_dto) {
        InferenceObj inference_obj = new InferenceObj();
        BeanUtils.copyProperties(inference_obj_dto, inference_obj);
        return InferenceObjRepository.save(inference_obj);
    }


    @Override
    public InferenceObj get_obj(Integer obj_id) {
        return InferenceObjRepository.findById(obj_id).orElseThrow(() -> {
            throw new IllegalArgumentException("no record found, check parameter!");
        });
    }

    @Override
    public List<Integer> findIdsByFileName(List<String> files){
        List<Integer> fileIds = new ArrayList<>();

        for (String fileName : files) {
            Optional<InferenceObj> inferenceObj = InferenceObjRepository.findByFileName(fileName);

            if (inferenceObj.isPresent()) {
                System.out.println(inferenceObj.get().getId());
                fileIds.add(inferenceObj.get().getId());
            }
        }

        return fileIds;
    }

    @Override
    public InferenceObj edit(InferenceObj inference_obj) {
        return InferenceObjRepository.save(inference_obj);
    }

    @Override
    public void delete(Integer obj_id) {
        InferenceObjRepository.deleteById(obj_id);
    }

    @Override
    public List<Map<String, String>>  run_inference(List<String> files, String modelType) {

        List<Integer> fileIds = findIdsByFileName(files);

        List<Map<String, String>> result = pythonService.sendRequestToPython(fileIds, modelType);


        return result;
    }
}
