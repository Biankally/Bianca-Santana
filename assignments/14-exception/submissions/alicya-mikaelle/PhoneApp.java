public class PhoneApp {
    public static void main(String[] args) {
        try {
            Phone phone1 = new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar o telefone: " + e.getMessage());
        }

        try {
            Phone phone2 = new Phone("Samsung", "1234567890123");
        } catch (ValidationException e) {
            System.out.println("Erro ao criar o telefone: " + e.getMessage());
        }

        try {
            Phone phone3 = new Phone("iPhone", "1234567890123456");
            System.out.println("Telefone criado com sucesso!");
            System.out.println("Nome: " + phone3.getName());
            System.out.println("Número de série: " + phone3.getSerialNumber());
        } catch (ValidationException e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
