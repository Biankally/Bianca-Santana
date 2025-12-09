public class TestException {
    public static void main(String[] args) {
       
        try {
            meuMetodoQueDisparaException(10);
        } catch (MyCustomException mc) {
            System.out.println("MyCustomException: " + mc.getMessage());
        }
        
        //meuMetodoQueDisparaException(10);
    
/*
        try {
            int i = 10 / 1;

            if (i <= 10)
                throw new MyCustomException("i não pode ser menor que 10");

            System.out.println(i);
        }
        catch (MyCustomException mc) {
            System.out.println("MyCustomException: " + mc.getMessage());
        }
        catch (ArithmeticException ae) {
              System.out.println("ArithmeticException: " + ae.getMessage());
        }
        catch (Exception exception) {
            System.out.println("Exception: " + exception.getMessage());
        } finally {
            System.out.println("Continua");
        }
             */
    }

    private static void meuMetodoQueDisparaException(int i) throws MyCustomException {
        
        System.out.println("Método que pode disparar exceção");

        if (i <= 10)
            throw new MyCustomException("i não pode ser menor que 10");

    }
}

class MyCustomException extends Exception{
    
    public MyCustomException(String message){
        super(message);
    }

    @Override
    public String getMessage(){
        return "Meu erro customizado " + super.getMessage();
    }
}