package com.graphqljava.tutorial.bookdetails.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.graphqljava.tutorial.bookdetails.domain.Gun;

import org.springframework.stereotype.Component;

@Component
public class GunRepo {
    public static List<Gun> data = new ArrayList<Gun>();

    @PostConstruct
    public static void init() {
        Gun firstGun = new Gun();
        firstGun.setId("gun-1");
        firstGun.setName("Winchester");
        firstGun.setCaliber("6.5");
        data.add(firstGun);

        Gun secondGun = new Gun();
        secondGun.setId("gun-2");
        secondGun.setName("Magnum");
        secondGun.setCaliber(".22");
        data.add(secondGun);

        Gun thirdGun = new Gun();
        thirdGun.setId("gun-3");
        thirdGun.setName("Creedmoor");
        thirdGun.setCaliber(".308");
        data.add(thirdGun);

        System.out.println("Gun Repo Done!");
    }
}