interface Notifier {
    void notify(String message);
}

interface Auditable {
    void audit(String message);
}

class ConsoleNotifier implements Notifier, Auditable {
    @Override
    public void notify(String message) {
        System.out.println("notify:" + message);
    }

    @Override
    public void audit(String message) {
        System.out.println("audit:" + message);
    }
}

class AlertService {
    private final Notifier notifier;

    AlertService(Notifier notifier) {
        this.notifier = notifier;
    }

    void trigger(String message) {
        notifier.notify(message);
    }
}

public class Q13 {
    public static void main(String[] args) {
        ConsoleNotifier backend = new ConsoleNotifier();
        AlertService service = new AlertService(backend);
        service.trigger("Build succeeded");
        backend.audit("Build succeeded");
    }
}
