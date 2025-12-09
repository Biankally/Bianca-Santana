import java.util.ArrayList;
import java.util.List;

public class SensorMonitor {
    private List<SensorReading> readings = new ArrayList<>();

    public void addReading(String rawInput) throws InvalidReadingException {
        if (rawInput == null || !rawInput.contains(";")) {
            throw new InvalidReadingException("Formato de entrada inválido. Use SENSOR_ID;TEMPERATURA.");
        }

        String[] parts = rawInput.split(";");
        if (parts.length != 2) {
            throw new InvalidReadingException("Formato de entrada inválido. Forneça exatamente um ID e uma temperatura.");
        }

        String sensorId = parts[0].trim();
        if (sensorId.isEmpty()) {
            throw new InvalidReadingException("O identificador do sensor não pode ser vazio.");
        }

        try {
            double temperature = Double.parseDouble(parts[1].trim());
            if (temperature < -30 || temperature > 55) {
                throw new InvalidReadingException("Temperatura fora da faixa permitida (-30°C a 55°C).");
            }
            this.readings.add(new SensorReading(sensorId, temperature));
        } catch (NumberFormatException e) {
            throw new InvalidReadingException("O valor da temperatura deve ser um número válido.");
        }
    }

    public double averageFor(String sensorId) throws SensorNotFoundException {
        double sum = 0;
        int count = 0;
        
        for (SensorReading reading : readings) {
            if (reading.getSensorId().equalsIgnoreCase(sensorId)) {
                sum += reading.getTemperature();
                count++;
            }
        }

        if (count == 0) {
            throw new SensorNotFoundException("Nenhuma leitura encontrada para o sensor " + sensorId + ".");
        }

        return sum / count;
    }

    public int getTotalReadings() {
        return readings.size();
    }
}