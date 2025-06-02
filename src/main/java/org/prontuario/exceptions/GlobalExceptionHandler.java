package org.prontuario.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CpfJaCadastradoException.class)
    public ResponseEntity<ExtendsErro> handleCpfJaCadastrado(CpfJaCadastradoException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new ExtendsErro(
                        Instant.now(),
                        HttpStatus.CONFLICT.value(),
                        ex.getMessage(),
                        request.getContextPath()
                )

        );
    }

    @ExceptionHandler(IdNaoLocalizado.class)
    public ResponseEntity<ExtendsErro> handleIdNaoLocalizado(IdNaoLocalizado ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.FOUND).body((
                new ExtendsErro(Instant.now(),
                        HttpStatus.FOUND.value(),
                        ex.getMessage(),
                        request.getContextPath())
                )
        );
    }

    @ExceptionHandler(NameNaoLocalizado.class)
    public ResponseEntity<ExtendsErro> handleNameNaoLocalizado(NameNaoLocalizado ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.FOUND).body((
                new ExtendsErro(Instant.now(),
                        HttpStatus.FOUND.value(),
                        ex.getMessage(),
                        request.getContextPath())
                )
        );
    }

    @ExceptionHandler(ProntuarioNaoLocalizado.class)
    public ResponseEntity<ExtendsErro> handleProntuarioNaoLocalizado(ProntuarioNaoLocalizado ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.FOUND).body((
                new ExtendsErro(Instant.now(),
                        HttpStatus.FOUND.value(),
                        ex.getMessage(),
                        request.getContextPath())
                )
        );
    }
}
