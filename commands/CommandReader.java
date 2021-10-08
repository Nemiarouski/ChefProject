package com.chef.commands;

public class CommandReader {
    public void work(Command command) {
        command.getName();
        command.execute();
    }
}