package com.kwolszczak.lego;

import java.util.ArrayList;
import java.util.List;

public class FluentLego {

    private String name;
    private double price;
    private int numberOfPieces;
    private boolean unique;
    private List<String> pieces;

    //privet constructor to prevent creating instance of FluentLego (new FluentLego() -not possible)
    private FluentLego(){
    }

    //static factory method, - FluentLego.builder();
    public static Builder builder(){
        return new Builder();
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return "Lego set:"+name
                + ". Price: "+price +" PLN"
                +". Number of pieces: "+numberOfPieces
                + " Unique: "+unique
                + " Elements: "+pieces;
    }

    //Inner Static Fluent Builder
    public static final class Builder{
        private String name;
        private double price;
        private int numberOfPieces;
        private boolean unique = false;
        private List<String> pieces= new ArrayList<>();

        public Builder addPiece(String piece){
            this.pieces.add(piece);
            return this;
        }

        public Builder price(double price){
            this.price = price;
            return this;
        }

        public Builder numberOfPieces(int numberOfPieces){
            this.numberOfPieces = numberOfPieces;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder unique(){
            this.unique = true;
            return this;
        }

        public FluentLego build(){

            if(name.isEmpty()){
                throw new IllegalStateException("Name cant be empty");
            }
            if (price <= 0){
                throw new IllegalStateException("price can not be <= 0");
            }

            FluentLego fluentLego = new FluentLego();
            fluentLego.name =this.name;
            fluentLego.price = this.price;
            fluentLego.unique = this.unique;
            fluentLego.numberOfPieces = this.numberOfPieces;
            fluentLego.pieces = this.pieces;
            return fluentLego;
        }
        
    }
}
