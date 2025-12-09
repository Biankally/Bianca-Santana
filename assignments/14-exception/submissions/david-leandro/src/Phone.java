public class Phone {
    private String name;
    private String serialNumber;

    /**
     * Construtor que valida e inicializa os atributos.
     * @param name O nome do telefone (ex: "iPhone 15").
     * @param serialNumber O número de série (deve ter exatamente 16 caracteres).
     * @throws ValidationException Se o nome ou o número de série for inválido.
     */
    public Phone(String name, String serialNumber) throws ValidationException {
        // Validação do nome
        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException("O nome do telefone não pode estar vazio.");
        }

        // Validação do número de série
        if (serialNumber == null || serialNumber.length() != 16) {
            throw new ValidationException("O número de série deve conter exatamente 16 dígitos.");
        }

        // Se as validações passarem, inicializa os atributos
        this.name = name;
        this.serialNumber = serialNumber;
        System.out.println("-> Telefone '" + this.name + "' criado com sucesso.");
    }

    // Opcional: getters para demonstrar acesso aos dados
    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}