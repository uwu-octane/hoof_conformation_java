package com.tao.cnndeployment.service;

import java.util.List;
import java.util.Map;

public interface InterfacePythonService {

    List<Map<String, String>> sendRequestToPython(List<Integer> input, String modelType);
}
