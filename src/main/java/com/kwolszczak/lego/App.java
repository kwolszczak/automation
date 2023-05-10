package com.kwolszczak.lego;

import java.util.Arrays;

public class App {

    private static final int ACCEPTABLE_PRICE = 1500;
    public static void main(String[] args) {
        /**
         * First option
         *
         * */
        var starWarsModel = new Lego("Star Wars", 100,50);
        var harryPotterModel = new Lego("Harry Potter", 500,460);
        var winnieThePoohModel = new Lego("Winnie the Pooh", 2_000,130);

        Arrays.asList(starWarsModel,harryPotterModel,winnieThePoohModel)
                .stream()
                .filter(model -> model.getPrice() < ACCEPTABLE_PRICE)
                .forEach(System.out::println);

        /**
         * Second option
         *
         * */
        Lego[] legoModelCollection = new Lego[]{
                new Lego("Star Wars", 100,50),
                new Lego("Harry Potter", 500,460),
                new Lego("Winnie the Pooh", 2_000,130)
        };

        for (Lego model : legoModelCollection) {
            if (model.getPrice() < ACCEPTABLE_PRICE) System.out.println(model);
        }

    }
}