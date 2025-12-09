import java.util.ArrayDeque;

public class Q02{
    public static void main(String[] args){
        
        ArrayDeque<Integer> d = new ArrayDeque<>(); 
        d.offer(18); 
        d.offer(5); 
        d.push(13); 
        System.out.println(d.poll() + " " + d.poll());  

    }
}
