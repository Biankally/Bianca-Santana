public class PhoneApp {

    public static void main(String[] args) {
        System.out.println("--- Testes de criação de Telefone ---");
        System.out.println(); 

        System.out.println("Tentar criar um objeto Phone com nome vazio");
        try {
            //Cria o telefone com dados errados
            Phone phone1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println("Mensagem: " + e.getMessage());
        }

        System.out.println("____________________________________________________________");
        System.out.println();


        System.out.println("Tentar criar um objeto Phone com número de série com menos de 16 dígitos");
        try {
            // Cria o telefone com serial number errado
            Phone phone2 = new Phone("Iphone 127", "12345");
        } catch (ValidationException e) {
            System.out.println("Mensagem: " + e.getMessage());
        }

        System.out.println("____________________________________________________________");
        System.out.println();

        System.out.println("Criar um objeto Phone com dados válidos e imprimir uma mensagem de sucesso");
        try {
            Phone phone3 = new Phone("Iphone 127", "SERIENUMBER12345");
            // O bloco catch não deve ser executado aqui.
        } catch (ValidationException e) {
            // Se entrar aqui, há um erro no código.
            System.out.println("ERRO INESPERADO -> Falhou com dados válidos. Mensagem: " + e.getMessage());
        }

    }
}
