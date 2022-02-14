package com.musala.drone.exception;

import com.musala.drone.domain.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiResponse<String > methodArgumentNotValidException(final MethodArgumentNotValidException ex) {

        Map<String, String> errorResponse = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            if (errorResponse.put(fieldError.getField(), fieldError.getDefaultMessage()) != null) {
                throw new IllegalStateException("Duplicate key");
            }
        }

        return ApiResponse.<String>builder().data("").error(errorResponse)
                .status(HttpStatus.BAD_REQUEST.value()).message("Input Validation Error").build();
    }


    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiResponse<String> handleUserNotFoundException(final BadRequestException ex) {

        return ApiResponse.<String>builder().data("").status(HttpStatus.BAD_REQUEST.value()).message(ex.getMessage())
                .error(ex.getMessage()).build();
    }
}
