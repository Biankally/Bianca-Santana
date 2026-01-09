
import java.io.FileOutputStream;
import java.io.IOException;

class FileOutputStreamDemoTryWithResources { 
    public static void main(String[] args) { 
        String source = """
                        Now is the time for all good men
                         to come to the aid of their country
                         and pay their due taxes."""; 

        byte[] buf = source.getBytes(); 
         
        try (
                FileOutputStream f3 = new FileOutputStream("file3.txt");
                FileOutputStream f4 = new FileOutputStream("file4.txt"); 
                FileOutputStream f5 = new FileOutputStream("file5.txt"); 
            ) {

            for (int i=0; i < buf.length; i += 1) f3.write(buf[i]); 

            f4.write(buf); 
 
            f5.write(buf, 0, buf.length); 

        } catch(IOException e) { 
            System.out.println("An I/O Error Occurred"); 
        } 
    } 
}