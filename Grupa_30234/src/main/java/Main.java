import model.Book;
import model.builder.BookBuilder;

import java.util.Date;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello world!");

        Book book = new BookBuilder()
                .setTitle("Fram Ursul Polar")
                .setAuthor("Cezar Petrescu")
                .setPublishedDate(new Date())
                .build();

        System.out.println(book);
    }
}
