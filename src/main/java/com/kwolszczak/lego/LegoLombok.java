package com.kwolszczak.lego;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
public class LegoLombok {

    private String name;
    @Getter private double price;
    private int numberOfPieces;
    private boolean unique;
    @Singular private List<String> pieces;



}
