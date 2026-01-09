import java.util.Map;

public class MapOfTest {
    public static void main(String[] args) {

        Map<String, Integer> dayMap = Map.of(
            "Monday", 1,
            "Tuesday", 2,
            "Wednesday", 3,
            "Thursday", 4,
            "Friday", 5,
            "Saturday", 6,
            "Sunday", 7
        );
        System.out.printf("dayMap: %s%n%n", dayMap);

        Map<String, Integer> daysPerMonthMap = Map.ofEntries(
            Map.entry("January", 31),
            Map.entry("February", 28),
            Map.entry("March", 31),
            Map.entry("April", 30),
            Map.entry("May", 31),
            Map.entry("June", 30),
            Map.entry("July", 31),
            Map.entry("August", 31),
            Map.entry("September", 30),
            Map.entry("October", 31),
            Map.entry("November", 30),
            Map.entry("December", 31)
        );
        System.out.printf("monthMap: %s%n", daysPerMonthMap);
    }
}
