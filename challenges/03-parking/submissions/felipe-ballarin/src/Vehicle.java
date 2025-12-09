public abstract class Vehicle{
    private String plate;
    private String brand;
    private String model;

    public Vehicle(String plate, String brand, String model){
        this.plate = plate;
        this.brand = brand;
        this.model = model;
    }

    public abstract double calculateParkingFee(int horas); //metodo abstratp, nao tem {}

    //_______________Get e set da placa______________
    
    public String getPlate() { //retorna o valor da placa
        return this.plate;  
    }

    public void setPlate(String plate) { //muda o valor da placa
        this.plate = plate;
    }

    //_______________Get e set da marca______________

    public String getBrand() { //retorna o valor da placa
        return this.brand;  
    }

    public void setBrand(String brand) { //muda o valor da placa
        this.brand = brand;
    }

    //_______________Get e set do modelo______________

    public String getModel() { //retorna o valor da placa
        return this.model;  
    }

    public void setModel(String model) { //muda o valor da placa
        this.model = model;
    }

    @Override 
    public String toString() { // Constroi e retorna a string formatada direito
        return "Placa: " + this.plate + " - Marca: " + this.brand + " - Modelo: " + this.model;
    }

}
