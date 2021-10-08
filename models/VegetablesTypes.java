package com.chef.models;

public enum VegetablesTypes implements Comparable<VegetablesTypes> {
    POTATO("Potato", 83),
    PEPPER("Pepper", 27),
    CUCUMBER("Cucumber", 15),
    TOMATOES("Tomatoes", 19),
    BEET("Beet", 48),
    CARROT("Carrot", 33),
    CORN("Corn", 123);

    private final String type;
    private final int calories;

    VegetablesTypes(String type, int calories) {
        this.type = type;
        this.calories = calories;
    }

    public String getType() {
        return type;
    }
    
    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return type + ", " + calories + " cal.";
    }
}