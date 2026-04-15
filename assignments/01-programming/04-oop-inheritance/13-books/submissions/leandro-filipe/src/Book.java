import java.util.Scanner;

// Superclasse
public abstract class Book {

    protected String title; // titulo do livro
    protected int year; // ano de publicação
    protected String author; // nome do autor

    // construtor da classe abstrata
    protected Book(String title, int year, String author){
 
        this.title = title;
        this.year = year;
        this.author = author;

    
    }
 

    // metodo para exibir infos da classe abstrata
    @Override
    public String ToString(){

        return String.format("Título: %s. Ano de publicação: %s. Autor: %s", getTitle(), getYear(), getAuthor());
    }
    // metodos get/set
    public String getTitle(){

        return title;
    }

    public void setTitle(String title){

        this.title = title;
    }

    public int getYear(){

        return year;
    }

    public void setYear(int year){

        this.year = year;
    }

    public String getAuthor(){

        return author;
    }

    public void setAuthor(String author){

        this.author = author;
    }


    
}

// Subclasse PrintBook

    public class PrintBook extends Book {


        private String publisher; // editora do livro
        private String isbn; // cod. ISBN do livro

        public PrintBook(String title, int year, String author, String publisher, String isbn){

            super(title, year, author);

            this.publisher = publisher;
            this.isbn = isbn;
        }

        public String getPublisher(){

        return publisher;

        }

        public String setPublisher(String publisher){

            this.publisher = publisher;
        }


        public String getIsbn(){

        return isbn;

        }

        public String setIsbn(String isbn){

            this.isbn = isbn;
        }


    }