package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;

@Command(description = "Compares two configuration files and shows a difference.",
        name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0")
public class App implements Runnable {
    @Option(names = {"-f","--format"},paramLabel = "format",description = "output format [default: stylish]")
    private String format = "stylish";

    @Parameters(index = "0",paramLabel = "filepath1", description = "path to first file")
    private File filepath1;

    @Parameters(index = "1",paramLabel = "filepath2", description = "path to second file")
    private File filepath2;


    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
    @Override
    public void run() {
        System.out.println("Hello World!");
    }
}
