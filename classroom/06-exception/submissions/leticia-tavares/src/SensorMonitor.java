import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorMonitor {

    private static final double MIN_TEMP = -30.0;
    private static final double MAX_TEMP = 55.0;

    private final Map<String, List<Double>> readings = new HashMap<>();

    public void addReading(String readingLine) throws InvalidReadingException {
        String[] parts = readingLine.split(";");
        if (parts.length != 2) {
            throw new InvalidReadingException("formato da linha inválido. Esperado: SENSOR_ID;TEMPERATURA");
        }

        String sensorId = parts[0].trim();
        String tempStr = parts[1].trim();

        if (sensorId.isEmpty()) {
            throw new InvalidReadingException("o identificador do sensor não pode estar vazio.");
        }

        double temperature;
        try {
            temperature = Double.parseDouble(tempStr.replaceAll(",", "."));
        } catch (NumberFormatException e) {
            throw new InvalidReadingException("temperatura inválida: '" + tempStr + "' não é um número.");
        }

        if (temperature < MIN_TEMP || temperature > MAX_TEMP) {
            throw new InvalidReadingException(String.format(
                    "temperatura fora da faixa permitida (%.1f°C a %.1f°C). valor lido: %.1f°C.",
                    MIN_TEMP, MAX_TEMP, temperature));
        }

        readings.computeIfAbsent(sensorId, k -> new ArrayList<>()).add(temperature);
    }

    public double averageFor(String sensorId) throws SensorNotFoundException {
        List<Double> temps = readings.get(sensorId.toUpperCase());
        
        if (temps == null || temps.isEmpty()) {
            throw new SensorNotFoundException(sensorId);
        }

        return temps.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);
    }
    
    public long getTotalValidReadingsCount() {
        return readings.values().stream().mapToLong(List::size).sum();
    }
}

