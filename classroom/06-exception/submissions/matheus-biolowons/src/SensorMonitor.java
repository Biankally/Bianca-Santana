import java.util.ArrayList;
import java.util.List;

public class SensorMonitor {
    private final List<SensorReading> readings = new ArrayList<>();

    public void addReading(String rawInput) throws InvalidReadingException {
        String[] parts = rawInput.split(";");

        if (parts.length != 2) throw new InvalidReadingException("Formato inválido. Esperado: ID;TEMPERATURA");

        String id = parts[0].trim();
        String tempString = parts[1].trim();

        if (id.isEmpty()) throw new InvalidReadingException("O ID do sensor não pode estar vazio.");

        double temperature;
        try {
            temperature = Double.parseDouble(tempString);
        } catch (NumberFormatException e) {
            throw new InvalidReadingException("Temperatura não numérica: " + tempString);
        }

        if (temperature < -30 || temperature > 55) {
            throw new InvalidReadingException("Temperatura fora da faixa (-30 a 55): " + temperature);
        }

        readings.add(new SensorReading(id, temperature));
    }

    public double averageFor(String sensorId) throws SensorNotFoundException {
        return readings.stream()
                .filter(r -> r.sensorId().equalsIgnoreCase(sensorId))
                .mapToDouble(SensorReading::temperature)
                .average()
                .orElseThrow(() -> new SensorNotFoundException("Nenhuma leitura encontrada para o sensor: " + sensorId));
    }

    public int totalReadings() {
        return readings.size();
    }
}