import java.util.ArrayList;
import java.util.List;

public class SensorMonitor {
    private List<SensorReading> readings;

    public SensorMonitor() {
        this.readings = new ArrayList<>();
    }

    public void addReading(String readingLine) throws InvalidReadingException {
        String[] parts = readingLine.split(";");

        if (parts.length != 2) {
            throw new InvalidReadingException("Formato de entrada inválido. Use 'id;temperatura'.");
        }

        try {
            int id = Integer.parseInt(parts[0].trim());
            
            String tempString = parts[1].trim();                       //Pega a parte da temperatura e remove espaços
            String tempStringCorrigida = tempString.replace(',', '.'); //Substitui a vírgula (,) por ponto (.)
            double temp = Double.parseDouble(tempStringCorrigida);     //converte para double

            if (temp < -30 || temp > 50) {
                throw new InvalidReadingException("Temperatura fora do limite permitido (-30 a 50).");
            }

            SensorReading newReading = new SensorReading(id, temp);
            this.readings.add(newReading);
            System.out.println("Leitura adicionada com sucesso!");

        } catch (NumberFormatException e) {
            throw new InvalidReadingException("ID ou temperatura não são números válidos.");
        }
    }

    public double getAverageTemperature() {
        if (readings.isEmpty()) { //previne a divisao por 0!
            return 0.0;
        }

        double sum = 0;
        for (SensorReading reading : readings) {
            sum += reading.getTemperature();
        }

        return sum / readings.size();
    }
}
