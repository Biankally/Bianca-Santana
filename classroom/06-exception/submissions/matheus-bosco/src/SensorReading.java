public final class SensorReading {

    private final String sensorId;
    private final double temperature;


    public SensorReading( String sensorId, double temperature) {

        this.sensorId = sensorId;
        this.temperature = temperature;
    }


    public String getSensorId(){
        return sensorId;
    }

    public double getTemperature(){
        return temperature;
    }


    @Override

    public String toString(){
        return "SensorReading{id='" + sensorId + "', temp=" + temperature + "}";
    }
    
}
