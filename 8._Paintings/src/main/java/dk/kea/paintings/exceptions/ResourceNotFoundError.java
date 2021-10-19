package dk.kea.paintings.exceptions;

/**
 * @author Julius Panduro
 */
public class ResourceNotFoundError extends RuntimeException {
    public ResourceNotFoundError(String message){
        super(message);
    }
}
