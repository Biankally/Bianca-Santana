import java.util.*;

public class SensorMonitor {
    private List<SensorReading> readings;
    private int validReadings;
    private int invalidReadings;

    public SensorMonitor() {
        this.readings = new ArrayList<>();
        this.validReadings = 0;
        this.invalidReadings = 0;
    }

    public void addReading(String line) throws InvalidReadingException {
        try {
            String[] parts = line.split(";");
            
            if (parts.length != 2) {
                throw new InvalidReadingException("Formato inválido. Use: SENSOR_ID;TEMPERATURA");
            }
            
            String sensorIdStr = parts[0].trim();
            String temperatureStr = parts[1].trim();
            
            if (sensorIdStr.isEmpty()) {
                throw new InvalidReadingException("ID do sensor não pode estar vazio");
            }
            
            int sensorId = Integer.parseInt(sensorIdStr);
            double temperature = Double.parseDouble(temperatureStr);
            
            if (temperature < -30.0 || temperature > 55.0) {
                throw new InvalidReadingException("Temperatura deve estar entre -30°C e 55°C");
            }
            
            readings.add(new SensorReading(sensorId, temperature));
            validReadings++;
            
        } catch (NumberFormatException e) {
            invalidReadings++;
            throw new InvalidReadingException("ID do sensor ou temperatura deve ser um número válido");
        }
    }

    public double averageFor(int sensorId) throws SensorNotFoundException {
        List<SensorReading> sensorReadings = new ArrayList<>();
        
        for (SensorReading reading : readings) {
            if (reading.getSensorId() == sensorId) {
                sensorReadings.add(reading);
            }
        }
        
        if (sensorReadings.isEmpty()) {
            throw new SensorNotFoundException("Nenhuma leitura encontrada para o sensor " + sensorId);
        }
        
        double sum = 0.0;
        for (SensorReading reading : sensorReadings) {
            sum += reading.getTemperature();
        }
        
        return sum / sensorReadings.size();
    }

    public int getValidReadings() {
        return validReadings;
    }

    public int getInvalidReadings() {
        return invalidReadings;
    }
}
