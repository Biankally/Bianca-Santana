import java.util.*;

public class SensorMonitor {
    private Map<String, List<SensorReading>> readings = new HashMap<>();

    // Adiciona uma leitura, validando o formato e faixa
    public void addReading(String input) throws InvalidReadingException {
        try {
            String[] parts = input.split(";");
            if (parts.length != 2) {
                throw new InvalidReadingException("Formato inválido! Use SENSOR_ID;TEMPERATURA.");
            }

            String id = parts[0].trim();
            if (id.isEmpty()) {
                throw new InvalidReadingException("O identificador do sensor não pode estar vazio!");
            }

            double temp = Double.parseDouble(parts[1].trim());
            if (temp < -30 || temp > 55) {
                throw new InvalidReadingException("Temperatura fora da faixa permitida (-30 a 55°C).");
            }

            readings.putIfAbsent(id, new ArrayList<>());
            readings.get(id).add(new SensorReading(id, temp));

        } catch (NumberFormatException e) {
            throw new InvalidReadingException("Temperatura inválida: deve ser um número.");
        }
    }

    // Calcula a média das leituras de um sensor
    public double averageFor(String sensorId) throws SensorNotFoundException {
        List<SensorReading> sensorList = readings.get(sensorId);
        if (sensorList == null || sensorList.isEmpty()) {
            throw new SensorNotFoundException("Nenhuma leitura encontrada para o sensor: " + sensorId);
        }

        double sum = 0;
        for (SensorReading r : sensorList) {
            sum += r.getTemperature();
        }
        return sum / sensorList.size();
    }

    public int totalReadings() {
        return readings.values().stream().mapToInt(List::size).sum();
    }
}
