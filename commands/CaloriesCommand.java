package com.chef.commands;

import com.chef.models.Vegetables;

import java.util.List;

public class CaloriesCommand implements Command {
    private final List<Vegetables> salad;

    public CaloriesCommand(List<Vegetables> salad) {
        this.salad = salad;
    }

    @Override
    public String getName() {
        return "Salad calories";
    }

    @Override
    public void execute() {
        getCalories();
    }

    private void getCalories() {
        salad.stream()
                .map(vegetables -> vegetables.getVegetablesType().getCalories())
                .reduce(Integer::sum)
                .ifPresent(integer -> System.out.println("Calories in salad: " + integer));
    }
}