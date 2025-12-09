/**
 * Representa um telefone com nome e número de série.
 * Valida os dados durante a sua criação.
 */
public class Phone {
    private String name;
    private String serialNumber;

    /**
     * Construtor para a classe Phone. Valida os dados de entrada.
     *
     * @param name         O nome do telefone.
     * @param serialNumber O número de série do telefone.
     * @throws ValidationException se o nome ou o número de série forem inválidos.
     */
    public Phone(String name, String serialNumber) throws ValidationException {
        // Validação 1: Nome não pode ser nulo ou vazio
        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException("O nome do telefone não pode estar vazio.");
        }

        // Validação 2: Número de série deve ter exatamente 16 caracteres
        if (serialNumber == null || serialNumber.length() != 16) {
            throw new ValidationException("O número de série deve conter exatamente 16 caracteres.");
        }

        // Se todas as validações passarem, inicializa os atributos
        this.name = name;
        this.serialNumber = serialNumber;
    }

    // Sobrescrever o método toString() para facilitar a impressão do objeto
    @Override
    public String toString() {
        return "Phone [Nome='" + name + "', Serial='" + serialNumber + "']";
    }
}