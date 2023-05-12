package com.kwolszczak.lego;

public class Lego {

    private String name;
    private double price;
    private int numberOfPieces;


    Lego(String name, double price, int numberOfPieces) {
        this.name = name;
        this.price = price;
        this.numberOfPieces = numberOfPieces;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return "Lego set:"+name+". Price: "+price+" PLN"+". Number of pieces: "+numberOfPieces;
    }

}
