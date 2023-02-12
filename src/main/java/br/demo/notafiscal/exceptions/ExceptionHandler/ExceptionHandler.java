package br.demo.notafiscal.exceptions.ExceptionHandler;

import br.demo.notafiscal.exceptions.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

        @org.springframework.web.bind.annotation.ExceptionHandler(value = { Exception.class })
        public final ResponseEntity<ExceptionResponse> handleAllExceptions(
                RuntimeException ex, WebRequest request) {
            ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
            String bodyOfResponse = "This should be application specific";
            return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

