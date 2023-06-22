package com.gym.controlapp.config.handler;

import com.gym.controlapp.config.exception.NotFoundException;
import com.gym.controlapp.config.exception.NotFoundExceptionBuilder;
import com.gym.controlapp.config.exception.SqlExceptionDetails;
import com.gym.controlapp.config.exception.ValidationExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundExceptionBuilder> handlerNotFoundException(NotFoundException ntf) {
        return new ResponseEntity<>(
                NotFoundExceptionBuilder
                        .builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .title("Not found Exception, check the documentation")
                        .details(ntf.getMessage())
                        .developerMsg(ntf.getClass().getName())
                        .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDetails> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldError = exception.getBindingResult().getFieldErrors();
        String fields = fieldError.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String fieldsMessage = fieldError.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));
        return new ResponseEntity<>(
                ValidationExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .title("Not found Exception, check the documentation")
                        .details("Check the fields error")
                        .developerMsg(exception.getClass().getName())
                        .fields(fields)
                        .fieldsMessage(fieldsMessage)
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<SqlExceptionDetails> sqlIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception) {
        return new ResponseEntity<>(
                SqlExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .title("Not found Exception, check the documentation")
                        .details("EXIST IN DATABASE")
                        .developerMsg(exception.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }
}