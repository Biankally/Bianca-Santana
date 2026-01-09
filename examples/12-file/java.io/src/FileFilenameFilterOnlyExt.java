import java.io.File;
import java.io.FilenameFilter;

public class FileFilenameFilterOnlyExt implements FilenameFilter { 
    String ext; 
    public FileFilenameFilterOnlyExt(String ext) { 
        this.ext = "." + ext; 
    } 
    
    @Override
    public boolean accept(File dir, String name) { 
        return name.endsWith(ext); 
    } 
} 