package com.kwolszczak.lego;

import java.util.stream.Stream;

public class FluentApp {

    private static final int ACCEPTABLE_PRICE = 1500;
    public static void main(String[] args) {
        /**
         * Inner Static Fluent Builder
         *
         * */

        var starWarsModel =  FluentLego.builder()
                .name("Star Wars")
                .price(100)
                .unique()
                .numberOfPieces(50)
                    .addPiece("jedi")
                    .addPiece("sky tank")
                    .addPiece("tower")
                .build();
        var harryPotterModel =  FluentLego.builder()
                .name("Harry Potter")
                .price(500)
                .numberOfPieces(460)
                .build();
        var winnieThePoohModel =  FluentLego.builder()
                .name("Winnie the Pooh")
                .price(2000)
                .build();

        Stream.of(starWarsModel, harryPotterModel, winnieThePoohModel)
                .filter(model -> model.getPrice() < ACCEPTABLE_PRICE)
                .forEach(System.out::println);

    }
}