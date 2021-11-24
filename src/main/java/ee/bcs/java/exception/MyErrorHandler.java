package ee.bcs.java.exception;


import ee.bcs.java.sample.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MyException.class)
    public ResponseEntity <Object> handleMyException(MyException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

    }
}
