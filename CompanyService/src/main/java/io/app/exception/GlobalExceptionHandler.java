package io.app.exception;

import io.app.dto.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RequiredFieldException.class)
    public ApiResponse handleRequiredFieldException(Exception ex){
        return new ApiResponse(ex.getMessage(),false);
    }

}
