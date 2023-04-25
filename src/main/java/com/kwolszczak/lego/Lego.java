package com.kwolszczak.lego;

public class Lego {

    private String name;
    private double price;
    private String[] pieces;

    Lego(double price) {
        this("Test", price,new String[1] );
    }
    Lego(String name, double price){
        this.name=name;
        this.price= price;
    }

    Lego(String name, double price, String[] pieces) {
        this.name = name;
        this.price = price;
        this.pieces = pieces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String[] getPieces() {
        return pieces;
    }

    public void setPieces(String[] pieces) {
        this.pieces = pieces;
    }

    @Override
    public String toString(){
        return "Lego set:"+name+". Price: "+price+" PLN";
    }
}
