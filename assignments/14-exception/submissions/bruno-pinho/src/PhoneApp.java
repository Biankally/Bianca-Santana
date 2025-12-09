/**
 * Classe principal para demonstrar a criação de objetos Phone
 * e o tratamento da ValidationException.
 */
public class PhoneApp {

    public static void main(String[] args) {
        System.out.println("--- Testes de Validação de Telefone ---");

        // Teste 1: Tentativa de criar um telefone com nome vazio
        System.out.println("\n1. Testando com nome vazio...");
        try {
            Phone phone1 = new Phone("", "1234567890123456");
            System.out.println("Sucesso: " + phone1); // Esta linha não deve ser alcançada
        } catch (ValidationException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }

        // Teste 2: Tentativa de criar um telefone com número de série inválido
        System.out.println("\n2. Testando com número de série curto...");
        try {
            Phone phone2 = new Phone("iPhone 17 Pro", "SN12345");
            System.out.println("Sucesso: " + phone2); // Esta linha não deve ser alcançada
        } catch (ValidationException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
        
        // Teste 3: Tentativa de criar um telefone com dados válidos
        System.out.println("\n3. Testando com dados válidos...");
        try {
            Phone phone3 = new Phone("Samsung Galaxy Z Fold 7", "SAMSUNGFOLD72025");
            System.out.println("Sucesso! Telefone criado: " + phone3);
        } catch (ValidationException e) {
            // Este bloco não deve ser executado neste caso
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}