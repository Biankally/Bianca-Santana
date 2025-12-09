import java.util.ArrayList;
import java.util.List;

public class SensorMonitor {

    private static final double MIN_TEMP = -30.0;
    private static final double MAX_TEMP = 55.0;

    private final List<SensorReading> readings = new ArrayList<>();

    public void addReading(String rawInput) throws InvalidReadingException {
        if (rawInput == null || rawInput.trim().isEmpty()) {
            throw new InvalidReadingException("Entrada não pode ser vazia.");
        }

        String[] parts = rawInput.split(";");
        if (parts.length != 2) {
            throw new InvalidReadingException("Formato inválido. Use ID_DO_SENSOR;TEMPERATURA.");
        }

        String sensorId = parts[0].trim();
        String tempStr = parts[1].trim();

        if (sensorId.isEmpty()) {
            throw new InvalidReadingException("ID do sensor não pode ser vazio.");
        }

        double temperature;
        try {
            temperature = Double.parseDouble(tempStr);
        } catch (NumberFormatException e) {
            throw new InvalidReadingException("Temperatura deve ser um número válido.");
        }

        if (temperature < MIN_TEMP || temperature > MAX_TEMP) {
            throw new InvalidReadingException("Temperatura fora da faixa permitida (" + MIN_TEMP + "°C a " + MAX_TEMP + "°C).");
        }

        readings.add(new SensorReading(sensorId, temperature));
    }

    public double averageFor(String sensorId) throws SensorNotFoundException {
        double totalTemp = 0.0;
        int count = 0;

        for (SensorReading reading : readings) {
            if (reading.getSensorId().equalsIgnoreCase(sensorId)) {
                totalTemp += reading.getTemperature();
                count++;
            }
        }

        if (count == 0) {
            throw new SensorNotFoundException("Nenhuma leitura encontrada para o sensor: " + sensorId);
        }

        return totalTemp / count;
    }

    public int getTotalReadings() {
        return readings.size();
    }
}