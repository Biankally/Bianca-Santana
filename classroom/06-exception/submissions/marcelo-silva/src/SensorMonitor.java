import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorMonitor {
    private Map<String, List<Double>> readings;

    public SensorMonitor() {
        this.readings = new HashMap<>();
    }

    public void addReading(String rawInput) throws InvalidReadingException {
        // Valida entrada não nula
        if (rawInput == null || rawInput.trim().isEmpty()) {
            throw new InvalidReadingException("Entrada vazia ou nula.");
        }

        // Separa os componentes
        String[] parts = rawInput.split(";");
        
        if (parts.length != 2) {
            throw new InvalidReadingException("Formato inválido. Use: SENSOR_ID;TEMPERATURA");
        }

        String sensorId = parts[0].trim();
        String tempStr = parts[1].trim();

        // Valida identificador
        if (sensorId.isEmpty()) {
            throw new InvalidReadingException("Identificador do sensor não pode estar vazio.");
        }

        // Valida temperatura
        double temperature;
        try {
            temperature = Double.parseDouble(tempStr);
        } catch (NumberFormatException e) {
            throw new InvalidReadingException("Temperatura inválida. Deve ser um número.");
        }

        // Valida faixa de temperatura
        if (temperature < -30.0 || temperature > 55.0) {
            throw new InvalidReadingException("Temperatura fora da faixa permitida (-30°C a 55°C).");
        }

        // Armazena a leitura
        readings.computeIfAbsent(sensorId, k -> new ArrayList<>()).add(temperature);
    }

    public double averageFor(String sensorId) throws SensorNotFoundException {
        if (!readings.containsKey(sensorId) || readings.get(sensorId).isEmpty()) {
            throw new SensorNotFoundException("Nenhuma leitura encontrada para o sensor: " + sensorId);
        }

        List<Double> temps = readings.get(sensorId);
        double sum = 0.0;
        for (double temp : temps) {
            sum += temp;
        }
        return sum / temps.size();
    }

    public int totalReadings() {
        int total = 0;
        for (List<Double> temps : readings.values()) {
            total += temps.size();
        }
        return total;
    }
}