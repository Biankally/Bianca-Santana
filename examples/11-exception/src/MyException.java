public class MyException extends Exception {
    
    public MyException(String message){
        super(message);
    }

    @Override
    public String getMessage(){
        return "Meu erro customizado " + super.getMessage();
    }
}
