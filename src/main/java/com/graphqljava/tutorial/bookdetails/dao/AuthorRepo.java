package com.graphqljava.tutorial.bookdetails.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import com.graphqljava.tutorial.bookdetails.domain.Author;
import com.graphqljava.tutorial.bookdetails.domain.Gun;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
public class AuthorRepo {

    public static List<Author> data = new ArrayList<Author>();

    @PostConstruct
    @DependsOn("GunRepo")
    public static void init() {

        Author firstAuthor = new Author();
        firstAuthor.setId("author-1");
        firstAuthor.setFirstName("Joanne");
        firstAuthor.setLastName("Rowling");
        data.add(firstAuthor);

        Author secondAuthor = new Author();
        secondAuthor.setId("author-2");
        secondAuthor.setFirstName("Herman");
        secondAuthor.setLastName("Melville");
        data.add(secondAuthor);

        Author thirdAuthor = new Author();
        thirdAuthor.setId("author-3");
        thirdAuthor.setFirstName("Anne");
        thirdAuthor.setLastName("Rice");
        data.add(thirdAuthor);

        GunRepo.init();
        List<Gun> guns = GunRepo.data;
        Gun firstGun = guns.stream().filter(gun -> gun.getId().equals("gun-1")).findFirst().orElse(null);
        Gun secondGun = guns.stream().filter(gun -> gun.getId().equals("gun-2")).findFirst().orElse(null);
        firstAuthor.setGuns(Arrays.asList(firstGun, secondGun));
        Gun thirdGun = guns.stream().filter(gun -> gun.getId().equals("gun-3")).findFirst().orElse(null);
        thirdAuthor.setGuns(Arrays.asList(thirdGun));

        System.out.println("Author Repo Done!");
    }

}