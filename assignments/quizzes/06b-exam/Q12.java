class Engine {
    private final int capacity;

    Engine(int capacity) {
        this.capacity = capacity;
    }

    int capacity() {
        return capacity * 2;
    }
}

class Car {
    private final Engine engine;

    Car(int capacity) {
        this.engine = new Engine(capacity);
    }

    int horsepowerEstimate() {
        return engine.capacity() * 2;
    }
}

public class Q12 {
    public static void main(String[] args) {
        Car car = new Car(90);
        System.out.println(car.horsepowerEstimate());
    }
}
