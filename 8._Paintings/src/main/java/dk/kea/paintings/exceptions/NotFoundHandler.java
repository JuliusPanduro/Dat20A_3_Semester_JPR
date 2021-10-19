package dk.kea.paintings.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Julius Panduro
 */
@RestControllerAdvice
public class NotFoundHandler {
    @ExceptionHandler(value = {ResourceNotFoundError.class})
    public ResponseEntity<?> handleApiRequestException(ResourceNotFoundError exception, HttpServletRequest request) {

        ErrorDetail errorDetail = new ErrorDetail(404, exception.getMessage(), request.getServletPath());

        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }
}




















   /* @ExceptionHandler(value = {ResourceNotFoundError.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorDetail handleApiRequestException(ResourceNotFoundError exception, HttpServletRequest request) {
        return new ErrorDetail(404, exception.getMessage(), request.getServletPath());
    }

    */
