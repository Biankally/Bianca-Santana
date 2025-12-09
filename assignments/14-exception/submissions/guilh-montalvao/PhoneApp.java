public class PhoneApp {
    public static void main(String[] args) {
        try {
            new Phone("", "1234567890123456");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        try {
            new Phone("Telefone Válido", "123456789012345");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        try {
            Phone validPhone = new Phone("Telefone Válido", "1234567890123456");
            System.out.println("Telefone criado com sucesso: " + validPhone.getName() + ", SN=" + validPhone.getSerialNumber());
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}
