package dk.kea.paintings.exceptions;

/**
 * @author Julius Panduro
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}
