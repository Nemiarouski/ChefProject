package com.chef.commands;

import com.chef.models.Vegetables;
import com.chef.utils.ConsoleUtils;
import java.util.List;

public class FindVegetableByCaloriesCommand implements Command {
    private final List<Vegetables> salad;

    public FindVegetableByCaloriesCommand(List<Vegetables> salad) {
        this.salad = salad;
    }

    @Override
    public String getName() {
        return "Find vegetable by calories:";
    }

    @Override
    public void execute() {
        findByRange();
    }

    private void findByRange() {
        System.out.println("Input first number");
        int firstNumber = ConsoleUtils.validateInt();

        System.out.println("Input second number");
        int secondNumber = ConsoleUtils.validateInt();

        if (secondNumber < firstNumber) {
            int temp = secondNumber;
            secondNumber = firstNumber;
            firstNumber = temp;
        }

        int finalFirstNumber = firstNumber;
        int finalSecondNumber = secondNumber;

        salad.stream()
                .filter(n -> n.getVegetablesType().getCalories() >= finalFirstNumber && n.getVegetablesType().getCalories() <= finalSecondNumber)
                .forEach(l -> System.out.println(l.getVegetablesType().getType() + ", " + l.getWeight() + "г. , " + l.getVegetablesType().getCalories() + " cal."));
    }
}