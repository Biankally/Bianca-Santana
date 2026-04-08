public class BookApp {
    public static void main(String[] args) {
        
        
        Book livroGenerico = new Book("Java: How to Program", 2017, "Paul Deitel e Harvey Deitel");
        
        PrintBook livroImpresso = new PrintBook(
            "Java: How to Program", 
            2017, 
            "Paul Deitel e Harvey Deitel",
            "Pearson",
            "978-0-13-474335-6"
        );
        
        AudioBook audioLivro = new AudioBook(
            "Java: How to Program", 
            2017, 
            "Paul Deitel e Harvey Deitel",
            245.5, 
            1250, 
            "John Smith"
        );

        
        System.out.println("=== Livro Genérico ===");
        System.out.println(livroGenerico);
        
        System.out.println("\n=== Livro Impresso ===");
        System.out.println(livroImpresso);
        
        System.out.println("\n=== Audiolivro ===");
        System.out.println(audioLivro);
    }
}
