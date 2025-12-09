import java.io.IOException; 
import java.io.FileNotFoundException; 

public class Q09 {
    public static void readFile(String name) throws Exception {
        if (name == null) throw new FileNotFoundException("invalid file name");  
    }
    public static void main(String[] args) {
        String file = null;
        try {
            readFile(file);
        } catch (IOException e) {
            System.out.print("IO error: " + e.getMessage());
        } catch (Exception e) {
            System.out.print("Other error: " + e.getMessage());
        } finally {
            System.out.print(" finally");
        }
        System.out.print(" the end");
    } 
}
