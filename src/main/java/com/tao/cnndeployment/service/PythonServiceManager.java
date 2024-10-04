package com.tao.cnndeployment.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PythonServiceManager {
    private Process pythonProcess;

    @Value("${python.service.server.path}")
    private String pythonServerPath;

    @Value("${python.service.envpath}")
    private String pythonEnvPath;
    // start python server when the spring project starts running
    @PostConstruct
    public void startPythonServer(){
        try{
            System.out.println("Starting Python server");
            String command = String.format("%s/bin/python %s", pythonEnvPath, pythonServerPath);
            pythonProcess = new ProcessBuilder(command.split(" ")).inheritIO()
                    .start();
            System.out.println("Python server started");
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    @PreDestroy
    public void stopPythonServer(){
        if (pythonProcess != null){
            System.out.println("Stopping Python server");

            pythonProcess.destroy();
            System.out.println("Python server stopped");
        }
    }
}
