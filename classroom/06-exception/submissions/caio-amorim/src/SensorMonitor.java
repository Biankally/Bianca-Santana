import java.util.*;

public class SensorMonitor {
    private Map<String, List<Double>> readings = new HashMap<>();

    public void addReading(String line) throws InvalidReadingException {
        String[] parts = line.split(";");
        if (parts.length != 2) {
            throw new InvalidReadingException("Formato inválido. Use SENSOR_ID;TEMPERATURA.");
        }

        String id = parts[0].trim();
        if (id.isEmpty()) {
            throw new InvalidReadingException("O identificador do sensor não pode estar vazio.");
        }

        double temp;
        try {
            temp = Double.parseDouble(parts[1].trim());
        } catch (NumberFormatException e) {
            throw new InvalidReadingException("A temperatura deve ser um número.");
        }

        if (temp < -30 || temp > 55) {
            throw new InvalidReadingException("Temperatura fora da faixa permitida (-30°C a 55°C).");
        }

        readings.putIfAbsent(id, new ArrayList<>());
        readings.get(id).add(temp);
    }

    public double averageFor(String id) throws SensorNotFoundException {
        List<Double> sensorData = readings.get(id);
        if (sensorData == null || sensorData.isEmpty()) {
            throw new SensorNotFoundException("Não há leituras registradas para o sensor informado.");
        }

        double soma = 0;
        for (double t : sensorData) soma += t;
        return soma / sensorData.size();
    }

    public int totalReadings() {
        int total = 0;
        for (List<Double> list : readings.values()) total += list.size();
        return total;
    }
}
