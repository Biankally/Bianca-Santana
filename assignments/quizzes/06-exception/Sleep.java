public class Sleep {
    public static void snore() throws Exception{
        try {
            String sheep[] = new String[3];
            System.out.print(sheep[3]);
        } catch (RuntimeException e) {
            System.out.print("Awake!");
        } finally {
            throw new Exception();
        }
    }
    public static void main(String... sheep) {  // x2
        try {
            snore(); 
        } catch (Exception e) {

        }   
    } 
}