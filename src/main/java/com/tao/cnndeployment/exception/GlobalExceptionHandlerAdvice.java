package com.tao.cnndeployment.exception;

import com.tao.cnndeployment.pojo.ResponseMessage;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {
    Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);


    @ExceptionHandler({Exception.class})
    public ResponseMessage handler_Exception(Exception e, HttpServletRequest request, HttpServletResponse response){

        log.error("backend error: ", e);
        return new ResponseMessage(500, "error", null);
    }
}
