package com.kwolszczak.lego;

public class Lego {

    private String name;
    private double price;
    private String[] pieces;

    Lego(double price) {
        this("Test", price,new String[1] );
    }

    Lego(String name, double price, String[] pieces) {
        this.name = name;
        this.price = price;
        this.pieces = pieces;
    }
}
