import java.util.ArrayList;
import java.util.List;

public class ParkingApp {
    public static void main(String[] args) {
        
        List<Vehicle> veiculos = new ArrayList<>();

        //adiciona os veiculos 
        veiculos.add(new Car("ABC-1234", "Honda", "WRV"));
        veiculos.add(new Motorcycle("XYZ-1234", "Honda", "CG 160"));
        veiculos.add(new Truck("ABC-0101", "Chevrolet", "D20"));

        int horas = 4;

        for (Vehicle veiculo_atual : veiculos) { //estrutura do enhanced lopp, veiculo atual é uma variavel temporaria!!
            double fee = veiculo_atual.calculateParkingFee(horas);
            System.out.println(veiculo_atual);
            System.out.printf("Valor a pagar por %dh: R$ %.2f%n%n", horas, fee);
        }

    }
}
