package BasketballChat.BasketballChat.controller;

import BasketballChat.BasketballChat.exception.GameNotFoundException;
import BasketballChat.BasketballChat.exception.TeamNotFoundException;
import BasketballChat.BasketballChat.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundHandler(UserNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(GameNotFoundException.class)
        public ResponseEntity<?> gameNotFoundHandler(GameNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        @ExceptionHandler(TeamNotFoundException.class)
    public ResponseEntity<?> teamNotFoundHandler(TeamNotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

