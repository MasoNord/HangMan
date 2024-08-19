package org.example;

import org.example.command.Command;
import org.example.command.QuitGameCommand;
import org.example.exception.InvalidCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        RenderClass renderClass = new RenderClass();
        CommandFactory commandFactory = new CommandFactory();
        Command<?> command = null;

        while(!(command instanceof QuitGameCommand)) {
            try {
                renderClass.renderIntroMenu();
                command = commandFactory.createCommand(reader.readLine());
                command.execute();
            }catch(InvalidCommand e) {
                System.out.println(e.getMessage());
                System.out.print("Press any key to continue...");
                reader.readLine();
            }
        }

        input.close();
    }
}