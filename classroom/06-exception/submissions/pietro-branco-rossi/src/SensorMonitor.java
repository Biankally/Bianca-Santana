import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorMonitor {
    private Map<String, List<Double>> readings = new HashMap<>();
    private int validReadingsCount = 0;
    private int ignoredReadingsCount = 0;

    public void addReading(String line) throws InvalidReadingException {
        String[] parts = line.split(";");

        if (parts.length != 2) {
            throw new InvalidReadingException("Formato de leitura inválido.");
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
            throw new InvalidReadingException("Temperatura inválida, não é um número.");
        }

        if (temperature < -30.0 || temperature > 55.0) {
            throw new InvalidReadingException("Temperatura fora da faixa válida (-30°C a 55°C).");
        }

        readings.putIfAbsent(sensorId, new ArrayList<>());
        readings.get(sensorId).add(temperature);
        validReadingsCount++;
    }

    public double averageFor(String sensorId) throws SensorNotFoundException {
        if (!readings.containsKey(sensorId) || readings.get(sensorId).isEmpty()) {
            throw new SensorNotFoundException("Não há leituras para o sensor solicitado.");
        }

        List<Double> temps = readings.get(sensorId);
        double sum = 0;
        for (double temp : temps) {
            sum += temp;
        }

        return sum / temps.size();
    }

    public int getValidReadingsCount() {
        return validReadingsCount;
    }

    public int getIgnoredReadingsCount() {
        return ignoredReadingsCount;
    }

    public void incrementIgnoredReadings() {
        this.ignoredReadingsCount++;
    }
}