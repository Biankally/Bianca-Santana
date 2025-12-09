import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {
    private final String url;
    private final String user;
    private final String password;
    private final String path;

    public Config () throws IOException {
        Properties env = new Properties();
        InputStream file = Files.newInputStream(Paths.get("db.properties"));
        env.load(file);

        this.url = env.getProperty("db.url");
        this.user = env.getProperty("db.user");
        this.password = env.getProperty("db.password");
        this.path = env.getProperty("csv.path");
    }

    public String getUrl() { return url; }
    public String getUser() { return user; }
    public String getPassword() {
        return password;
    }
    public String getPath() {
        return path;
    }
}
