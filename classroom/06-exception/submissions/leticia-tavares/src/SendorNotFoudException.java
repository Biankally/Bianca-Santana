public class SensorNotFoundException extends Exception {
    
    public SensorNotFoundException(String sensorId) {
        super("não foram encontradas leituras para o sensor: " + sensorId);
    }

}