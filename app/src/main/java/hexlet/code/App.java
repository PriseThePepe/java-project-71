package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(description = "Compares two configuration files and shows a difference.",
        name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0")
public class App implements Runnable {

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
    @Override
    public void run() {
        System.out.println("Hello World!");
    }
}
