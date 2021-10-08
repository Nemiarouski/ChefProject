package com.chef.models;

public class Vegetables {
    private final VegetablesTypes vegetablesType;
    private int weight;

    public Vegetables(VegetablesTypes vegetablesType, int weight) {
        this.vegetablesType = vegetablesType;
        this.weight = weight;
    }

    public VegetablesTypes getVegetablesType() {
        return vegetablesType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void addWeight(int weight) {
        this.weight += weight;
    }

    @Override
    public String toString() {
        return vegetablesType.getType() + ", " + weight + " г.";
    }
}