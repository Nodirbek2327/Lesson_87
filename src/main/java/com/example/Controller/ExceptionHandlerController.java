package com.example.Controller;

import com.example.exp.AppBadRequestException;
import com.example.exp.ItemNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
 /*   @ExceptionHandler(AppBadRequestException.class)
    public ResponseEntity<String> handler(AppBadRequestException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<String> handler(ItemNotFoundException e) {
        e.printStackTrace();
        return ResponseEntity.badRequest().body(e.getMessage());
    }
*/
    @ExceptionHandler({ItemNotFoundException.class, AppBadRequestException.class})
    public ResponseEntity<String> handlerAll(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
