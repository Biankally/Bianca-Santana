public class Truck extends Vehicle{

    public Truck(String plate, String brand, String model){
        super(plate, brand, model); //chama o construtor da superclasse
    }

    @Override //metodo era abstrato, precisamos sobreescrever
    public double calculateParkingFee(int horas){
        return horas * 10;
    }
}
