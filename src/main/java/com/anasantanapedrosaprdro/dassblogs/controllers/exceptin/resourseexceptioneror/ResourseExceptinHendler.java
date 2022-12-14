package com.anasantanapedrosaprdro.dassblogs.controllers.exceptin.resourseexceptioneror;

import com.anasantanapedrosaprdro.dassblogs.controllers.exceptin.standarerror.StandarError;
import com.anasantanapedrosaprdro.dassblogs.services.exeptions.EntityNotFoundExcepion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourseExceptinHendler {
    @ExceptionHandler(EntityNotFoundExcepion.class)
    public ResponseEntity<StandarError> entityNotFound(EntityNotFoundExcepion e, HttpServletRequest request){
        StandarError error =new StandarError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Resource not found");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
