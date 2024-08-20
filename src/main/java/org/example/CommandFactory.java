package org.example;

import org.example.command.Command;
import org.example.command.HelpCommand;
import org.example.command.NewGameCommand;
import org.example.command.QuitGameCommand;
import org.example.exception.InvalidCommand;

import java.io.IOException;

public class CommandFactory {

    public Command<?> createCommand(String name) throws InvalidCommand, IOException {
        return switch (name) {
            case "1" -> new NewGameCommand(new Game(), new RenderClass());
            case "2" -> new QuitGameCommand();
            case "3" -> new HelpCommand();
            default -> throw new InvalidCommand("Wrong choice!, try again...");
        };
    }
}
