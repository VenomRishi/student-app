package com.bridgelabz.studentapp.exception;

import com.bridgelabz.studentapp.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = CustomException.class)
  public ResponseEntity<ResponseDto> handleCustomException(CustomException customException) {
    return new ResponseEntity<>(new ResponseDto(customException.getMessage(), null),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = ValidationException.class)
  public ResponseEntity<ResponseDto> handleValidationException(ValidationException validationException) {
    return new ResponseEntity<>(new ResponseDto(validationException.getMessage(), null),
        HttpStatus.NOT_FOUND);
  }
}
