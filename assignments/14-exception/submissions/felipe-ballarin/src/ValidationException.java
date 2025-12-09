public class ValidationException extends Exception {

    public ValidationException(String mensagem){
        super(mensagem);
    }

    public ValidationException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }

}
