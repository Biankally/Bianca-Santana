import java.util.HashMap;

public class HashMapApp {
    public static void main(String[] args) {
        System.out.println("1) Associate Key with Value");
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"Verde"); map.put(2,"Amarelo"); map.put(3,"Azul");
        System.out.println(map);

        System.out.println("\n2) Count Key-Value Mappings");
        System.out.println(map.size());

        System.out.println("\n3) Copy Mappings to Another Map");
        HashMap<Integer,String> map2 = new HashMap<>(map);
        System.out.println(map2);

        System.out.println("\n4) Remove All Mappings");
        HashMap<Integer,String> temp = new HashMap<>(map);
        temp.clear(); System.out.println(temp);

        System.out.println("\n5) Check If Map is Empty");
        System.out.println(temp.isEmpty());

        System.out.println("\n6) Get Shallow Copy (clone)");
        @SuppressWarnings("unchecked")
        HashMap<Integer,String> clone = (HashMap<Integer,String>) map.clone();
        System.out.println(clone);

        System.out.println("\n7) Check If Key Exists (2)");
        System.out.println(map.containsKey(2));

        System.out.println("\n8) Check If Value Exists ('Azul')");
        System.out.println(map.containsValue("Azul"));

        System.out.println("\n9) Get Entry Set View");
        System.out.println(map.entrySet());

        System.out.println("\n10) Get Value by Key (3)");
        System.out.println(map.get(3));

        System.out.println("\n11) Get Key Set");
        System.out.println(map.keySet());

        System.out.println("\n12) Get Values Collection");
        System.out.println(map.values());
    }
}
