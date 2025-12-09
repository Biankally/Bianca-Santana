import java.util.*;


public class HashMapApp {


    public static void main(String[] args) {
        System.out.println("Associate Key with Value");
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"Verde"); map.put(2,"Amarelo"); map.put(3,"Azul");
        System.out.println(map);

        System.out.println("Count Key-Value Mappings");
        System.out.println(map.size());

        System.out.println("Copy Mappings to Another Map");
        HashMap<Integer,String> copia = new HashMap<>(map);
        System.out.println(copia);

        System.out.println("Remove All Mappings");
        HashMap<Integer,String> temp = new HashMap<>(map);
        temp.clear();
        System.out.println(temp);

        System.out.println("Check If Map is Empty");
        System.out.println(temp.isEmpty());

        System.out.println("Get Shallow Copy");
        @SuppressWarnings("unchecked")
        HashMap<Integer,String> clone = (HashMap<Integer,String>) map.clone();
        System.out.println(clone);

        System.out.println("Check If Key Exists");
        System.out.println(map.containsKey(2));

        System.out.println("Check If Value Exists");
        System.out.println(map.containsValue("Azul"));

        System.out.println("Get Entry Set View");
        System.out.println(map.entrySet());

        System.out.println("Get Value by Key");
        System.out.println(map.get(3));

        System.out.println("Get Key Set");
        System.out.println(map.keySet());

        System.out.println("Get Values Collection");
        System.out.println(map.values());
    }


}
