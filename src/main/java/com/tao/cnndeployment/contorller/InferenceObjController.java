package com.tao.cnndeployment.contorller;


import com.tao.cnndeployment.pojo.FileUploadResponse;
import com.tao.cnndeployment.pojo.InferenceObj;

import com.tao.cnndeployment.pojo.InferenceObjDTO;
import com.tao.cnndeployment.pojo.ResponseMessage;
import com.tao.cnndeployment.service.InterfaceInferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InferenceObjController {

    @Autowired
    InterfaceInferenceService inference_service;


    @PostMapping("/upload")
    public ResponseEntity<List<FileUploadResponse>> upload_images(@Validated @RequestParam("files") MultipartFile[] files) throws IOException {
        List<FileUploadResponse> uploadResponses = new ArrayList<>();

        for(MultipartFile file : files) {

            if(file != null){
                InferenceObjDTO inference_obj_dto = new InferenceObjDTO();
                try{
                    byte[] file_data = file.getBytes();
                    inference_obj_dto.setFileData(file_data);
                    String file_name = file.getOriginalFilename();
                    inference_obj_dto.setFileName(file_name);

                    inference_service.add(inference_obj_dto);
                    uploadResponses.add(new FileUploadResponse(file.getOriginalFilename(), "ok"));

                } catch (IOException e) {
                    e.printStackTrace();
                    uploadResponses.add(new FileUploadResponse("unknown", "error"));
                }
            }
        }

        return ResponseEntity.ok(uploadResponses);
    }

    @GetMapping("/{obj_id}" )
    public ResponseMessage get(@PathVariable Integer obj_id){
        InferenceObj obj_get = inference_service.get_obj(obj_id);
        return  ResponseMessage.success(obj_get);
    }


    @PutMapping
    public ResponseMessage edit(@Validated @RequestBody InferenceObj inference_obj){
        InferenceObj obj_edited =  inference_service.edit(inference_obj);
        return ResponseMessage.success(obj_edited);
    }

    @DeleteMapping("/{obj_id}" )
    public ResponseMessage delete(@PathVariable Integer obj_id){
        inference_service.delete(obj_id);
        return  ResponseMessage.success();
    }
}
