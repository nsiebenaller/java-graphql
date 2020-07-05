package com.graphqljava.tutorial.bookdetails;

import com.graphqljava.tutorial.bookdetails.dao.BookRepo;
import com.graphqljava.tutorial.bookdetails.dao.GunRepo;
import com.graphqljava.tutorial.bookdetails.domain.Author;
import com.graphqljava.tutorial.bookdetails.domain.Book;
import com.graphqljava.tutorial.bookdetails.domain.Gun;

import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.annotation.PostConstruct;

@Component
public class GraphQLDataFetchers {

    @PostConstruct
    public void init() {
    }

    public DataFetcher<Book> getBookById() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return BookRepo.data.stream().filter(book -> book.getId().equals(bookId)).findFirst().orElse(null);
        };
    }

    public DataFetcher<Author> getAuthor() {
        return dataFetchingEnvironment -> {
            Book book = dataFetchingEnvironment.getSource();
            return book.getAuthor();
        };
    }

    public DataFetcher<List<Gun>> getAllGuns() {
        return dataFetchingEnvironment -> {
            return GunRepo.data;
        };
    }

    public DataFetcher<List<Gun>> getGuns() {
        return dataFetchingEnvironment -> {
            Author author = dataFetchingEnvironment.getSource();
            return author.getGuns();
        };
    }

    public DataFetcher<List<Book>> getAllBooks() {
        return dataFetchingEnvironment -> {
            return BookRepo.data;
        };
    }
}
