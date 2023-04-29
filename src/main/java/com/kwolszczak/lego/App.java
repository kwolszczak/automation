package com.kwolszczak.lego;

import java.util.ArrayList;
import java.util.List;

public class App {

    private static final int ACCEPTABLE_PRICE = 1500;
    public static void main(String[] args) {

        /**
         * First option
         *
         * */
        var starWarsModel = new Lego("Star Wars", 100);
        var harryPotterModel = new Lego("Harry Potter", 500);
        var winnieThePoohModel = new Lego("Winnie the Pooh", 2_000);

        List<Lego> legoModelPack = new ArrayList<>();
        legoModelPack.add(starWarsModel);
        legoModelPack.add(harryPotterModel);
        legoModelPack.add(winnieThePoohModel);

        legoModelPack.stream().filter(model -> model.getPrice() < ACCEPTABLE_PRICE).forEach(System.out::println);

        /**
         * Second option
         *
         * */
        Lego[] legoModelCollection = new Lego[]{
                new Lego("Star Wars", 100),
                new Lego("Harry Potter", 500),
                new Lego("Winnie the Pooh", 2_000)
        };

        for (Lego model : legoModelCollection) {
            /*var acceptableModel = model.getPrice()<acceptablePrice ? model : null;
            System.out.println(acceptablePrice);*/
            if (model.getPrice() < ACCEPTABLE_PRICE) System.out.println(model);
        }

    }
}
