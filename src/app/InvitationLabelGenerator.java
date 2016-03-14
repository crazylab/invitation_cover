package app;

import com.command.CLI;
import util.IO;

import java.io.IOException;

public class InvitationLabelGenerator {
    public static void main(String[] command) throws IOException {
        IO io = new IO();
        CLI cli = new CLI(io);
        cli.runCommand(command);
    }
}