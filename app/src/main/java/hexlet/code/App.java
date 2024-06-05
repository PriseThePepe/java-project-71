package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(description = "Compares two configuration files and shows a difference.",
        name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0")
public class App implements Callable<String> {
    @Option(names = {"-f", "--format"}, paramLabel = "format",description = "output format [default: stylish]")
    private String format = "stylish";

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filepath1;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filepath2;


    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
    @Override
    public String call() {
        try {
            System.out.println(Differ.generate(filepath1, filepath2));
            return Differ.generate(filepath1, filepath2);
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

}
