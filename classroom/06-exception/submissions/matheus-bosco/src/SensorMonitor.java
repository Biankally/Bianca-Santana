import java.util.*;



public class SensorMonitor {

    private final  Map<String, List <Double>> readingsBySensor = new HashMap<>();


    public void addReading(String rawInput) throws InvalidReadingException {

        if (rawInput == null){
            throw new InvalidReadingException("Linha vazia!");

        }


        String [] parts = rawInput.split (";", -1);

        if (parts.length != 2) {

            throw new InvalidReadingException("Formato inválido");

            
        }

        String id = parts[0].trim();
        String tempStr = parts[1].trim();


        if (id.isEmpty()) {

            throw new InvalidReadingException("Identificador do sensor não pode estar vazio");
        }

        if (tempStr.isEmpty()) {

            throw new InvalidReadingException("A temperatura não foi informada");
        }

        final double temperature;
        
        try {
            temperature = Double.parseDouble(tempStr);
        } catch (NumberFormatException e) {

            throw new InvalidReadingException("Temperature inválida. Informe um numero double");
        }

        if (temperature < -30.0 || temperature > 55.0) {

            throw new InvalidReadingException("Informe uma temperatura dentro da fixa permitida ( -30.0 - 55.0)" + temperature);
        }; 


         List<Double> list = readingsBySensor.get(id);
        if (list == null) {
            list = new ArrayList<>();
            readingsBySensor.put(id, list);
        }
        list.add(temperature);
    }



    public double averageFor(String sensorId) throws SensorNotFoundException {
        List<Double> temps = readingsBySensor.get(sensorId);
        if (temps == null || temps.isEmpty()) {
            throw new SensorNotFoundException("Não há leituras para o sensor '" + sensorId + "'.");
        }

        double soma = 0.0;
        for (int i = 0; i < temps.size(); i++) {
            soma += temps.get(i);
        }
        return soma / temps.size();
    }

 
    
    public int totalReadings() {
        int total = 0;
        for (List<Double> list : readingsBySensor.values()) {
            total += list.size();
        }
        return total;
    }

   
    public int totalSensors() {
        return readingsBySensor.size();
    }

   
    public Set<String> sensors() {
        return Collections.unmodifiableSet(readingsBySensor.keySet());
    }
}
