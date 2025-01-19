/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.spotify.exception;

import com.umg.spotify.entity.Track;
import com.umg.spotify.reponse.DataResponse;
import com.umg.spotify.reponse.ErrorResponse;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author jonathangonzalez
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<DataResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now().toString(),
                ex.getClass().getSimpleName()
        );
        DataResponse<Track> response = new DataResponse<>(false, error);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<DataResponse> handleAlreadyExistsException(AlreadyExistsException ex) {
        ErrorResponse error = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.CONFLICT.value(),
                LocalDateTime.now().toString(),
                ex.getClass().getSimpleName()
        );
        DataResponse<Track> response = new DataResponse<>(false, error);
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DataResponse> handleGenericException(Exception ex) {
        ErrorResponse error = new ErrorResponse(
                "An internal server error has occurred. Please try again later.",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now().toString(),
                ex.getClass().getSimpleName()
        );
        DataResponse<Track> response = new DataResponse<>(false, error);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
