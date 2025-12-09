import java.util.ArrayList; 
import java.util.List; 

public class Q01 {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("Anna"); strList.add("Ada"); strList.add("Ada");
        strList.add("Bob"); strList.add("Bob"); strList.add("Adda");
        for (int i = 0; i < strList.size(); /* empty */) {
            if (strList.get(i).length() <= 3) {
                strList.remove(i);
            } else {
                ++i;    
            }
        }
        System.out.println(strList);
    } 
}
