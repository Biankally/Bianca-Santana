class Logger {
    Logger() {
        System.out.println("Logger");
    }

    Logger(String target) {
        this();
        System.out.println("Logger->" + target);
    }

    public void log(String message) {
        System.out.println("[DEBUG]" + message);
    }
}

class FileLogger extends Logger {
    FileLogger() {
        this("app.log");
        System.out.println("FileLogger default");
    }

    FileLogger(String name) {
        super(name);
        System.out.println("FileLogger->" + name);
    }

    @Override
    public void log(String message) {
        System.out.println("[INFO] " + message);
    }
}

public class Q08 {
    public static void main(String[] args) {
        Logger logger = new FileLogger();
        logger.log("Processing");
    }
}
