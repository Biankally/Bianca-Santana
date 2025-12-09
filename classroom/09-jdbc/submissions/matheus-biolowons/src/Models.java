public class Models {
    public record Film(
            Integer id,
            String title,
            int languageId,
            int rentalDuration,
            double rentalRate,
            double replacementCost
    ) {}

    public record Actor(
            Integer id,
            String firstName,
            String lastName
    ) {}
}