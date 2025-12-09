public class PhoneApp {
    public static void main(String[] args) {
        System.out.println("Iniciando  Validação\n");

        // Nome Vazio
        try {
            System.out.println("Tentativa 1: Criando telefone sem nome...");
            Phone p1 = new Phone("", "1234567890123456");

        } catch (ValidationException e) {
            System.err.println("ERRO CAPTURADO: " + e.getMessage());
        }

        System.out.println("--------------------------------------------------");

        // Serial Inválido
        try {
            System.out.println("Tentativa 2: Criando telefone com serial curto...");
            Phone p2 = new Phone("Samsung Galaxy", "12345");

        } catch (ValidationException e) {
            System.err.println("ERRO CAPTURADO: " + e.getMessage());
        }

        System.out.println("--------------------------------------------------");

        // Dados Válidos
        try {
            System.out.println("Tentativa 3: Criando telefone com dados válidos...");
            Phone p3 = new Phone("iPhone 15", "qwertyuiopasdfgh");

            System.out.println("SUCESSO: Objeto criado! -> " + p3.toString());

        } catch (ValidationException e) {
            System.err.println("ERRO INESPERADO: " + e.getMessage());
        }
    }
}