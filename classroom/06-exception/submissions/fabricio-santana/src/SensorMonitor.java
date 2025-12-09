import java.util.ArrayList;
import java.util.List;

public class SensorMonitor {
    public static final double MIN_TEMPERATURE = -30.0;
    public static final double MAX_TEMPERATURE = 55.0;

    private final List<SensorReading> readings = new ArrayList<>();

    public void addReading(String rawInput) throws InvalidReadingException {
        if (rawInput == null || rawInput.isBlank()) {
            throw new InvalidReadingException("Entrada vazia ou nula.");
        }

        String[] parts = rawInput.split(";", -1);
        if (parts.length != 2) {
            throw new InvalidReadingException("Formato inválido. Use SENSOR_ID;TEMPERATURA.");
        }

        String sensorId = parts[0].trim();
        String temperaturePart = parts[1].trim();

        if (sensorId.isEmpty()) {
            throw new InvalidReadingException("Identificador do sensor ausente.");
        }

        double temperature;
        try {
            temperature = Double.parseDouble(temperaturePart);
        } catch (NumberFormatException exception) {
            throw new InvalidReadingException("Valor de temperatura inválido: " + temperaturePart, exception);
        }

        if (temperature < MIN_TEMPERATURE || temperature > MAX_TEMPERATURE) {
            throw new InvalidReadingException(
                    String.format(
                            "Temperatura %.2f°C fora da faixa permitida (%.1f°C a %.1f°C)",
                            temperature,
                            MIN_TEMPERATURE,
                            MAX_TEMPERATURE
                    )
            );
        }

        readings.add(new SensorReading(sensorId, temperature));
    }

    public double averageFor(String sensorId) throws SensorNotFoundException {
        if (sensorId == null || sensorId.isBlank()) {
            throw new SensorNotFoundException("Informe um identificador de sensor válido.");
        }

        double total = 0.0;
        int counter = 0;

        for (SensorReading reading : readings) {
            if (sensorId.equalsIgnoreCase(reading.getSensorId())) {
                total += reading.getTemperature();
                counter++;
            }
        }

        if (counter == 0) {
            throw new SensorNotFoundException("Não há leituras registradas para o sensor " + sensorId + ".");
        }

        return total / counter;
    }

    public int totalReadings() {
        return readings.size();
    }
}
