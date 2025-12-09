import java.util.ArrayList;
import java.util.List;

public class SensorMonitor {

    private List<SensorReading> readings = new ArrayList<>();

    /**
     * Recebe a linha crua no formato "SENSOR_ID;TEMPERATURA"
     * Valida e adiciona à lista ou lança InvalidReadingException.
     */
    public void addReading(String rawLine) throws InvalidReadingException {
        if (rawLine == null) {
            throw new InvalidReadingException("Linha nula.");
        }

        String line = rawLine.trim();
        if (line.isEmpty()) {
            throw new InvalidReadingException("Linha vazia.");
        }

        String[] parts = line.split(";");
        if (parts.length != 2) {
            throw new InvalidReadingException(
                    "Formato inválido. Use SENSOR_ID;TEMPERATURA (ex: S1;25.5).");
        }

        String sensorId = parts[0].trim();
        String tempStr = parts[1].trim();

        if (sensorId.isEmpty()) {
            throw new InvalidReadingException("Identificador do sensor não pode ser vazio.");
        }

        double temperature;
        try {
            temperature = Double.parseDouble(tempStr);
        } catch (NumberFormatException e) {
            throw new InvalidReadingException("Temperatura deve ser um número válido.");
        }

        if (temperature < -30.0 || temperature > 55.0) {
            throw new InvalidReadingException(
                    "Temperatura fora da faixa permitida (-30 °C a 55 °C).");
        }

        // Se passou por todas as validações, adiciona
        readings.add(new SensorReading(sensorId, temperature));
    }

    /**
     * Retorna a média das temperaturas para um sensor.
     * Lança SensorNotFoundException se não houver leituras.
     */
    public double averageFor(String sensorId) throws SensorNotFoundException {
        double sum = 0.0;
        int count = 0;

        for (SensorReading reading : readings) {
            if (reading.getSensorId().equalsIgnoreCase(sensorId)) {
                sum += reading.getTemperature();
                count++;
            }
        }

        if (count == 0) {
            throw new SensorNotFoundException(
                    "Não há leituras registradas para o sensor: " + sensorId);
        }

        return sum / count;
    }

    public int getTotalValidReadings() {
        return readings.size();
    }
}
