package com.chef.commands;

import com.chef.models.Vegetables;
import com.chef.utils.ConsoleUtils;
import java.util.List;

public class SortsCommand implements Command {
    private final List<Command> showCommands;

    public SortsCommand(List<Vegetables> salad) {
        this.showCommands = List.of(new SortByWeightCommand(salad), new SortByCaloriesCommand(salad));
    }

    @Override
    public String getName() {
        return "Sort vegetables by";
    }

    @Override
    public void execute() {
        for (int i = 0; i < showCommands.size(); i++) {
            System.out.println((i + 1) + ") " + showCommands.get(i).getName());
        }
        int choice = ConsoleUtils.validateIntToValue(showCommands.size());
        showCommands.get(choice - 1).execute();
    }
}