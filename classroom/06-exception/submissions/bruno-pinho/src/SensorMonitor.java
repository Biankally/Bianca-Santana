// SensorMonitor.java
import java.util.ArrayList;
import java.util.List;

public class SensorMonitor {
    private List<SensorReading> readings = new ArrayList<>();

    /**
     * Valida uma entrada de leitura, e se for válida, a armazena.
     * @param rawInput A linha de texto digitada pelo usuário (ex: "S1;25.5").
     * @throws InvalidReadingException Se a entrada tiver formato, ID ou temperatura inválidos.
     */
    public void addReading(String rawInput) throws InvalidReadingException {
        // 1. Valida o formato geral (deve conter um ';')
        String[] parts = rawInput.split(";");
        if (parts.length != 2) {
            throw new InvalidReadingException("Formato da leitura inválido. Use SENSOR_ID;TEMPERATURA.");
        }

        // 2. Valida o identificador do sensor (não pode ser vazio)
        String sensorId = parts[0].trim();
        if (sensorId.isEmpty()) {
            throw new InvalidReadingException("O identificador do sensor não pode estar vazio.");
        }

        // 3. Valida e converte a temperatura
        double temperature;
        try {
            temperature = Double.parseDouble(parts[1].trim());
        } catch (NumberFormatException e) {
            throw new InvalidReadingException("A temperatura deve ser um número válido.");
        }

        // 4. Valida a faixa da temperatura
        if (temperature < -30 || temperature > 55) {
            throw new InvalidReadingException("Temperatura fora da faixa permitida (-30°C a 55°C).");
        }

        // Se tudo estiver válido, adiciona a leitura à lista
        this.readings.add(new SensorReading(sensorId, temperature));
    }

    /**
     * Calcula a temperatura média para um sensor específico.
     * @param sensorId O identificador do sensor a ser consultado.
     * @return A temperatura média das leituras do sensor.
     * @throws SensorNotFoundException Se não houver leituras para o sensor informado.
     */
    public double averageFor(String sensorId) throws SensorNotFoundException {
        double totalTemperature = 0;
        int readingsCount = 0;

        for (SensorReading reading : this.readings) {
            if (reading.getSensorId().equalsIgnoreCase(sensorId)) {
                totalTemperature += reading.getTemperature();
                readingsCount++;
            }
        }

        if (readingsCount == 0) {
            throw new SensorNotFoundException("Nenhuma leitura encontrada para o sensor '" + sensorId + "'.");
        }

        return totalTemperature / readingsCount;
    }

    /**
     * Retorna o número total de leituras válidas armazenadas.
     * @return A quantidade de leituras.
     */
    public int getTotalReadings() {
        return this.readings.size();
    }
}