public class PhoneApp {
    
    public static void main(String[] args) {
        System.out.println("=== Teste de Validação de Telefones ===\n");
        
        System.out.println("Teste 1: Criando telefone com nome vazio...");
        try {
            Phone phone1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("Teste 2: Criando telefone com número de série inválido...");
        try {
            Phone phone2 = new Phone("iPhone", "123456789");
        } catch (ValidationException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("Teste 3: Criando telefone com dados válidos...");
        try {
            Phone phone3 = new Phone("Samsung Galaxy", "1234567890123456");
            System.out.println("Sucesso! Telefone criado: " + phone3);
        } catch (ValidationException e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("Teste 4: Criando telefone com nome nulo...");
        try {
            Phone phone4 = new Phone(null, "1234567890123456");
        } catch (ValidationException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("Teste 5: Criando telefone com número de série nulo...");
        try {
            Phone phone5 = new Phone("Motorola", null);
        } catch (ValidationException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("Teste 6: Criando telefone com número de série com mais de 16 dígitos...");
        try {
            Phone phone6 = new Phone("LG", "12345678901234567");
        } catch (ValidationException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
        
        System.out.println("\n=== Todos os testes concluídos ===");
    }
}
