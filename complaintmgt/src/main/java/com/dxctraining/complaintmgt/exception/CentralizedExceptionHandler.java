package com.dxctraining.complaintmgt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CentralizedExceptionHandler {

	 @ExceptionHandler(ComplaintNotFoundException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public String handleEmployeeNotFound(ComplaintNotFoundException e){
	        System.out.println("inside handleComplaintNotFound");
	        String msg=e.getMessage();
	        return msg;
	    }

	    @ExceptionHandler(InvalidArgumentException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public String handleInvalidArgument(InvalidArgumentException e){
	        System.out.println("inside handleInvalidArgument");
	        return e.getMessage();
	    }

}
