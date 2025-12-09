public class Remember {
    public static void think() throws Exception {  // k1
        try {
            throw new Exception("Error");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String... ideas) throws Exception {
        think();
        System.out.println("Continue");
    } 
}
