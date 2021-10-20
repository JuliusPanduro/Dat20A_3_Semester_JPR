package dk.kea.paintings.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Julius Panduro
 */
@RestControllerAdvice
public class ResourceNotFoundHandler {
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<?> handleApiRequestException(ResourceNotFoundException exception, HttpServletRequest request) {

        ExceptionDetail exceptionDetail = new ExceptionDetail(404, exception.getMessage(), request.getServletPath());

        return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);
    }
}




















   /* @ExceptionHandler(value = {ResourceNotFoundError.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorDetail handleApiRequestException(ResourceNotFoundError exception, HttpServletRequest request) {
        return new ErrorDetail(404, exception.getMessage(), request.getServletPath());
    }

    */
