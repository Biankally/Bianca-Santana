class Animal {
    public String som() {
        return "Algum som";
    }
}

class Cachorro extends Animal {
    @Override
    public String som() {
        return "Au au";
    }

    public String pegarBola(){
        return "pegar Bola";
    }
}

class Gato extends Animal {
    @Override
    public String som() {
        return "Miau";
    }
}

public class Q02 {
    public static void main(String[] args) {
        Animal[] animais = { new Cachorro(), new Gato(), new Animal() };
        for (Animal a : animais) {
            System.out.println(a.som());
            if (a instanceof Cachorro)
                System.out.println(((Cachorro)a).pegarBola());
        }
    }
}