public class Phone {
    private final String name;
    private final String serialNumber;

    public Phone(String name, String serialNumber) throws ValidationException {
        validateName(name);
        validateSerialNumber(serialNumber);

        this.name = name;
        this.serialNumber = serialNumber;
    }

    private void validateName(String name) throws ValidationException {
        if (name == null || name.isEmpty()) {
            throw new ValidationException("O nome do telefone não pode estar vazio.");
        }
    }

    private void validateSerialNumber(String serialNumber) throws ValidationException {
        if (serialNumber == null || serialNumber.length() != 16) {
            throw new ValidationException("O número de série deve conter exatamente 16 dígitos.");
        }
    }

    @Override
    public String toString() {
        return "Phone [Nome: " + name + ", Serial: " + serialNumber + "]";
    }
}