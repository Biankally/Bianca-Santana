public class Phone {
    private final String name;
    private final String serialNumber;

    public Phone(String name, String serialNumber) throws ValidationException {
        String inputName = name == null ? null : name.trim();
        String inputSerialNumber = serialNumber == null ? null : serialNumber.trim();

        if (inputName == null || inputName.isEmpty()) {
            throw new ValidationException("O nome do telefone não pode estar vazio.");
        }

        if (inputSerialNumber == null || inputSerialNumber.isEmpty() || inputSerialNumber.length() != 16) {
            throw new ValidationException("O número de série deve conter exatamente 16 dígitos.");
        }

        this.name = inputName;
        this.serialNumber = inputSerialNumber;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}
