/**
 * Exceção personalizada para representar erros de validação de dados.
 */
public class ValidationException extends Exception {

    /**
     * Construtor que aceita uma mensagem de erro.
     *
     * @param message A descrição detalhada do erro de validação.
     */
    public ValidationException(String message) {
        // Chama o construtor da superclasse (Exception) para armazenar a mensagem.
        super(message);
    }

    /**
     * Construtor que aceita uma mensagem e uma causa (outra exceção).
     * Útil para encadear exceções.
     *
     * @param message A descrição detalhada do erro de validação.
     * @param cause A exceção original que causou este erro.
     */
    public ValidationException(String message, Throwable cause) {
        // Chama o construtor da superclasse para armazenar a mensagem e a causa.
        super(message, cause);
    }
}