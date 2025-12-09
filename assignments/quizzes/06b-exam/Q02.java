public class Q02 {
    public static void main(String[] args) {
        final int maxUsers = 6;
        var connected = 4;
        char status = connected < maxUsers ? 'O' : 'F';
        boolean canConnect = status == 'O' && (connected += 2) <= maxUsers;
        String banner = canConnect ? "Open" : "Full";
        System.out.println(status + " " + connected + " " + banner);
    }
}
