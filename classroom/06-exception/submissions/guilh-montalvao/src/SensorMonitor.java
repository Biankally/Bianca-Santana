import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorMonitor {
    private final Map<String, List<Double>> readingsBySensor = new HashMap<>();
    private int validCount;
    private int invalidCount;

    public void addReading(String line) throws InvalidReadingException {
        if (line == null) {
            invalidCount++;
            throw new InvalidReadingException("Formato invalido. Use SENSOR_ID;TEMPERATURA_EM_CELSIUS.");
        }

        String trimmed = line.trim();
        String[] parts = trimmed.split(";");
        if (parts.length != 2) {
            invalidCount++;
            throw new InvalidReadingException("Formato invalido. Use SENSOR_ID;TEMPERATURA_EM_CELSIUS.");
        }

        String sensorId = parts[0].trim();
        String tempStr = parts[1].trim();

        if (sensorId.isEmpty()) {
            invalidCount++;
            throw new InvalidReadingException("Identificador do sensor nao pode ser vazio.");
        }

        double temperature;
        try {
            temperature = Double.parseDouble(tempStr.replace(',', '.'));
        } catch (NumberFormatException e) {
            invalidCount++;
            throw new InvalidReadingException("Temperatura deve ser um numero valido.", e);
        }

        if (temperature < -30.0 || temperature > 55.0) {
            invalidCount++;
            throw new InvalidReadingException("Temperatura deve estar entre -30 C e 55 C.");
        }

        readingsBySensor.computeIfAbsent(sensorId, id -> new ArrayList<>()).add(temperature);
        validCount++;
    }

    public int getValidCount() {
        return validCount;
    }

    public int getInvalidCount() {
        return invalidCount;
    }

    public int getTotalReadings() {
        int sum = 0;
        for (List<Double> list : readingsBySensor.values()) {
            sum += list.size();
        }
        return sum;
    }

    public List<Double> getReadingsFor(String sensorId) {
        return readingsBySensor.get(sensorId);
    }

    public double averageFor(String sensorId) throws SensorNotFoundException {
        List<Double> list = readingsBySensor.get(sensorId);
        if (list == null || list.isEmpty()) {
            throw new SensorNotFoundException("Nao ha leituras para o sensor \"" + sensorId + "\".");
        }
        double totalTemperature = 0.0;
        for (double value : list) {
            totalTemperature += value;
        }
        return totalTemperature / list.size();
}
}
