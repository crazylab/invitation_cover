package app;

import com.command.CLI;
import com.util.IO;

import java.io.IOException;

public class LabelGenerator {
    public static void main(String[] command) throws IOException {
        IO io = new IO();
        CLI cli = new CLI(io);
        cli.runCommand(command);
    }
}