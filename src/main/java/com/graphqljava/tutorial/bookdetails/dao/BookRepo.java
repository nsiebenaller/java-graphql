package com.graphqljava.tutorial.bookdetails.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.graphqljava.tutorial.bookdetails.domain.Author;
import com.graphqljava.tutorial.bookdetails.domain.Book;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
public class BookRepo {
        public static List<Book> data = new ArrayList<Book>();

        @PostConstruct
        @DependsOn("AuthorRepo")
        public static void init() {
                Book firstBook = new Book();
                firstBook.setId("book-1");
                firstBook.setName("Harry Potter and the Philosopher's Stone");
                firstBook.setPageCount("223");
                data.add(firstBook);

                Book secondBook = new Book();
                secondBook.setId("book-2");
                secondBook.setName("Moby Dick");
                secondBook.setPageCount("635");
                data.add(secondBook);

                Book thirdBook = new Book();
                thirdBook.setId("book-3");
                thirdBook.setName("Interview with the vampire");
                thirdBook.setPageCount("371");
                data.add(thirdBook);

                AuthorRepo.init();
                List<Author> authors = AuthorRepo.data;
                Author firstAuthor = authors.stream().filter(author -> author.getId().equals("author-1")).findFirst()
                                .orElse(null);
                firstBook.setAuthor(firstAuthor);
                Author secondAuthor = authors.stream().filter(author -> author.getId().equals("author-2")).findFirst()
                                .orElse(null);
                secondBook.setAuthor(secondAuthor);
                Author thirdAuthor = authors.stream().filter(author -> author.getId().equals("author-3")).findFirst()
                                .orElse(null);
                thirdBook.setAuthor(thirdAuthor);

                System.out.println("Book Repo Done!");
        }

}