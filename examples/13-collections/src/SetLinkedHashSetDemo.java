import java.util.LinkedHashSet;

class SetLinkedHashSetDemo {
    public static void main(String[] args) {

        LinkedHashSet<String> hs = new LinkedHashSet<>();

        hs.add("Beta");
        hs.add("Alpha");
        hs.add("Eta");
        hs.add("Gamma");
        hs.add("Epsilon");
        hs.add("Omega");

        System.out.println(hs);
    }
}
