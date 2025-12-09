
import java.io.FileOutputStream;
import java.io.IOException;

class FileOutputStreamDemo2 { 
    public static void main(String[] args) { 
        String source = """
                        Now is the time for all good men
                         to come to the aid of their country
                         and pay their due taxes."""; 

        byte[] buf = source.getBytes(); 
        
        FileOutputStream f0 = null; 
        FileOutputStream f1 = null; 
        FileOutputStream f2 = null; 

        try { 
            f0 = new FileOutputStream("file0.txt"); 
            f1 = new FileOutputStream("file1.txt"); 
            f2 = new FileOutputStream("file2.txt"); 

            for (int i=0; i < buf.length; i += 1) f0.write(buf[i]); 

            f1.write(buf); 
 
            f2.write(buf, 0, buf.length); 

        } catch(IOException e) { 
            System.out.println("An I/O Error Occurred"); 
        } finally { 

            try { 
                if(f0 != null) f0.close(); 
            } catch(IOException e) { 
                System.out.println("Error Closing file1.txt"); 
            } 

            try { 
                if(f1 != null) f1.close(); 
            } catch(IOException e) { 
                System.out.println("Error Closing file2.txt"); 
            } 

            try { 
                if(f2 != null) f2.close(); 
            } catch(IOException e) { 
                System.out.println("Error Closing file3.txt"); 
            } 
        } 
    } 
}