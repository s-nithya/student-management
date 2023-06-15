package com.tcs.student.studentmanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
@ResponseBody
public class StudentExceptionHandler {


    Logger logger = LoggerFactory.getLogger(StudentExceptionHandler.class);

    @ExceptionHandler(value = {StudentNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handleStudentNotException(StudentNotFoundException stx) {
        logger.error("Error occurred", stx);
        return new ErrorResponse(HttpStatus.NOT_FOUND.toString(), stx.getMessage(), LocalDateTime.now());

    }

    @ExceptionHandler(value = {StudentAlreadyExistsException.class})
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorResponse handleStudentAlreadyExistException(StudentAlreadyExistsException stx) {
        logger.error("Error occurred", stx);
        return new ErrorResponse(HttpStatus.CONFLICT.toString(), stx.getMessage(), LocalDateTime.now());

    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception stx) {
        stx.printStackTrace();
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Unknown error occurred", LocalDateTime.now());


    }

}
