package com.chef.commands;

import com.chef.models.Vegetables;
import java.util.Comparator;
import java.util.List;

public class SortByWeightCommand implements Command {
    private final List<Vegetables> salad;

    public SortByWeightCommand(List<Vegetables> salad) {
        this.salad = salad;
    }

    @Override
    public String getName() {
        return "Sort by weight";
    }

    @Override
    public void execute() {
        sortingByWeight();
    }

    private void sortingByWeight() {
        salad.stream()
                .sorted(Comparator.comparing(Vegetables::getWeight))
                .forEach(l -> System.out.println(l.getVegetablesType().getType() + ", " + l.getWeight() + "г. , " + l.getVegetablesType().getCalories() + " cal."));
    }
}