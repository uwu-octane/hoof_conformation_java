package com.tao.cnndeployment.service;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tao.cnndeployment.pojo.ModelType;
import org.hibernate.event.spi.ResolveNaturalIdEvent;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PythonService implements InterfacePythonService{
    private final RestTemplate restTemplate;

    @Value("${pyrhon.service.url}")
    private String url;

    public PythonService() {
        this.restTemplate =  new RestTemplate();
    }



    @Override
    public List<Map<String, String>> sendRequestToPython(List<Integer> input, String modelType) {
        JSONObject requestJson = new JSONObject();
        requestJson.put("input", input);
        requestJson.put("modelType", modelType);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestJson.toString(), headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);

        // 解析返回的JSON
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> responseList = new ArrayList<>();

        try {
            responseList = mapper.readValue(responseEntity.getBody(), new TypeReference<List<Map<String, String>>>(){});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return responseList;
    }
}
