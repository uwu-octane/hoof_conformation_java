package com.tao.cnndeployment.contorller;

import com.tao.cnndeployment.pojo.InferenceRequest;
import com.tao.cnndeployment.pojo.InferenceResult;
import com.tao.cnndeployment.pojo.ModelType;
import com.tao.cnndeployment.pojo.ResponseMessage;
import com.tao.cnndeployment.service.InferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class InferenceController {
    @Autowired
    private InferenceService inferenceService;

    @PostMapping("/segment")
    public  List<Map<String, String>> run_inference(@RequestBody InferenceRequest request) {
        List<String> files = request.getFiles();
        String model = request.getModel();

        List<Map<String, String>> result = inferenceService.run_inference(files, model);
        System.out.println(result);
        return result;
    }
}
