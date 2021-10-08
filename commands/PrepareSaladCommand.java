package com.chef.commands;

import com.chef.models.Vegetables;
import com.chef.models.VegetablesTypes;
import com.chef.utils.ConsoleUtils;
import java.util.List;

public class PrepareSaladCommand implements Command {
    private final List<VegetablesTypes> types = List.of(VegetablesTypes.values());
    private final List<Vegetables> salad;

    public PrepareSaladCommand(List<Vegetables> salad) {
        this.salad = salad;
    }

    @Override
    public String getName() {
        return "Add vegetable to salad:";
    }

    @Override
    public void execute() {
        addVegetableToSalad();
    }

    private void addVegetableToSalad() {
        showVegetables();

        System.out.println("Choose vegetable: ");
        int choice = ConsoleUtils.validateIntToValue(types.size());

        System.out.println("Choose weight: ");
        int weight = ConsoleUtils.validateInt();

        boolean flag = false;

        for (Vegetables vegetables : salad) {
            if (vegetables.getVegetablesType().equals(types.get(choice - 1))) {
                vegetables.addWeight(weight);
                flag = true;
            }
        }

        if (!flag) {
            salad.add(new Vegetables(types.get(choice - 1), weight));
        }
    }

    private void showVegetables() {
        for (int i = 0; i < types.size(); i++) {
            System.out.println(i + 1 + ") " + types.get(i));
        }
    }
}