public class BookApp {
    public static void main(String[] args) {
        Book book = new Book("Clean Code", 2008, "Robert C. Martin");
        PrintBook printBook = new PrintBook("Design Patterns", 1994, "Erich Gamma", "Addison-Wesley", "978-0201633610");
        AudioBook audioBook = new AudioBook("Atomic Habits", 2018, "James Clear", 250.5, 400, "John Doe");

        System.out.println(book);
        System.out.println(printBook);
        System.out.println(audioBook);
    }
}
