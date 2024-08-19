package org.example.command;

import java.io.IOException;

public interface Command<T> {
    void execute() throws IOException;
}
