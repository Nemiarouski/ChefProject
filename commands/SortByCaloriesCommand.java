package com.chef.commands;

import com.chef.models.Vegetables;
import java.util.Comparator;
import java.util.List;

public class SortByCaloriesCommand implements Command {
    private final List<Vegetables> salad;

    public SortByCaloriesCommand(List<Vegetables> salad) {
        this.salad = salad;
    }

    @Override
    public String getName() {
        return "Sort by calories";
    }

    @Override
    public void execute() {
        sortingByCalories();
    }

    private void sortingByCalories() {
        salad.stream()
                .sorted(Comparator.comparing(l -> l.getVegetablesType().getCalories()))
                .forEach(l -> System.out.println(l.getVegetablesType().getType() + ", " + l.getWeight() + "г. , " + l.getVegetablesType().getCalories() + " cal."));
    }
}