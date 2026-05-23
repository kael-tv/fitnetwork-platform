package com.fitnetwork.user_service.exception;

import com.fitnetwork.user_service.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler { ///TODO commentaires

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ApiResponse<Void>> handleNotFound(ResourceNotFoundException ex) {
                ApiResponse<Void> response = ApiResponse.<Void>builder()
                        .status(404)
                        .success(false)
                        .message(ex.getMessage())
                        .data(null)
                        .build();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ApiResponse<Void>> handleValidation(MethodArgumentNotValidException ex) {
                String message = ex.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(error -> error.getField() + ": " + error.getDefaultMessage())
                        .collect(Collectors.joining(", "));
                ApiResponse<Void> response = ApiResponse.<Void>builder()
                        .status(400)
                        .success(false)
                        .message(message)
                        .data(null)
                        .build();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ApiResponse<Void>> handleGeneric(Exception ex) {
                ApiResponse<Void> response = ApiResponse.<Void>builder()
                        .status(500)
                        .success(false)
                        .message("Internal server error")
                        .data(null)
                        .build();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
}