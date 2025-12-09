public class ValidationException extends Exception {

    // Construtor que recebe apenas a mensagem
    public ValidationException(String message) {
        super(message);
    }

    // Construtor que recebe a mensagem e a causa
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
