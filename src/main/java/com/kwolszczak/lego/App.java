package com.kwolszczak.lego;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        /**
         * First idea
         *
         * */
        var starWarsModel = new Lego("Star Wars", 100);
        var harryPotterModel = new Lego("Harry Potter", 500);
        var winnieThePoohModel = new Lego("Winnie the Pooh", 2_000);

        List<Lego> legoList = new ArrayList<>();
        legoList.add(starWarsModel);
        legoList.add(harryPotterModel);
        legoList.add(winnieThePoohModel);

        legoList.stream().filter(ob -> ob.getPrice() < 1_500).forEach(System.out::println);


        /**
         * Second idea
         *
         * */
        Lego[] arrayLego = new Lego[]{
                new Lego("Star Wars", 100),
                new Lego("Harry Potter", 500),
                new Lego("Winnie the Pooh", 2_000)
        };

        for (Lego model : arrayLego) {
            //var below1000 = model.getPrice()<1500 ? model : null;
            //System.out.println(below1000);
            if (model.getPrice() < 1500) System.out.println(model);
        }

    }
}
