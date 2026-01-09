import java.io.FileInputStream;
import java.io.IOException;

class FileInputStreamReadFileCompactVersion { 
    public static void main(String[] args) { 
        int i; 
        FileInputStream fin= null; 
        try { 
            fin = new FileInputStream(args[0]); 
            do { 
                i = fin.read(); 
                if(i != -1) System.out.print((char) i); 
            } while(i != -1); 
        } catch(IOException e) { 
            System.out.println("I/O Error: " + e); 
        } finally { 
            try { 
                if(fin != null) fin.close(); 
            } catch(IOException e) { 
                System.out.println("Error Closing File"); 
            } 
        }
    }
} 