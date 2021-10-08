package com.chef.console;

import com.chef.commands.*;
import com.epam.chef.commands.*;
import com.chef.models.Vegetables;
import com.chef.utils.ConsoleUtils;
import java.util.ArrayList;
import java.util.List;

public class Chef {
    private final List<Vegetables> salad = new ArrayList<>();
    private final List<Command> menuCommands = new ArrayList<>();
    private final CommandReader commandReader = new CommandReader();

    public void start() {
        fillMenuCommands();
        prepareSalad();
    }

    private void fillMenuCommands() {
        addCommand(menuCommands, new PrepareSaladCommand(salad));
        addCommand(menuCommands, new CaloriesCommand(salad));
        addCommand(menuCommands, new SortsCommand(salad));
        addCommand(menuCommands, new FindVegetableByCaloriesCommand(salad));
        addCommand(menuCommands, new ExitCommand());
    }

    private void showMenu() {
        for (int i = 0; i < menuCommands.size(); i++) {
            System.out.println((i + 1) + ") " + menuCommands.get(i).getName());
        }
    }

    private void addCommand(List<Command> commands, Command command) {
        commands.add(command);
    }

    private void prepareSalad() {
        int choice;
        Command command;
        do {
            showMenu();
            choice = ConsoleUtils.validateIntToValue(menuCommands.size());
            command = menuCommands.get(choice - 1);
            commandReader.work(command);
        } while (!command.getName().equals("Exit"));
    }
}