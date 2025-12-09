public class SensorReading {
    private int sensorId;
    private double temperature;

    public SensorReading(int sensorId, double temperature) { 
        this.sensorId = sensorId;
        this.temperature = temperature;
    }

    public int getSensorId() { //metodo get
        return sensorId;
    }

    public double getTemperature() {
        return temperature;
    }
}
