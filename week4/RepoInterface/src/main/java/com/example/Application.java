package com.example;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(AppConfig.class)
            .web(WebApplicationType.SERVLET)
            .run(args);

        AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
        BookRepository bookRepository = context.getBean(BookRepository.class);

        
        Author author = new Author("RK");
        authorRepository.save(author);

        Book book1 = new Book("1984");
        Book book2 = new Book("Malgudi Days");
        author.addBook(book1);
        author.addBook(book2);

       
        bookRepository.save(book1);
        bookRepository.save(book2);

        authorRepository.findAll().forEach(a -> {
            System.out.println("Author: " + a.getName());
            a.getBooks().forEach(b -> System.out.println(" - Book: " + b.getTitle()));
        });
    }
}
