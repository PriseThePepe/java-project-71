package hexlet.code;

import hexlet.code.Parser.Parser;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Map;

public class Differ {
    public static String generate(String firstFilepath, String secondFilepath, String format) throws IOException {
        Path firstPath = Paths.get(firstFilepath).toAbsolutePath();
        Path secondPath = Paths.get(secondFilepath).toAbsolutePath();

        String firstContent = Files.readString(firstPath);
        String secondContent = Files.readString(secondPath);

        String firstFileExtension = getFileExtension(firstFilepath);
        String secondFileExtension = getFileExtension(secondFilepath);


        Map<String, Object> parsedFirstFile =  Parser.parse(firstContent, firstFileExtension);
        Map<String, Object> parsedSecondFile = Parser.parse(secondContent, secondFileExtension);

        Map<String, Status> diffMap = DifferGenerator.getDiff(parsedFirstFile, parsedSecondFile);


        return Formatter.format(diffMap, format);
    }
    public static String generate(String firstFilepath, String secondFilepath) throws IOException {
        return generate(firstFilepath, secondFilepath, "stylish");
    }

    private static String getFileExtension(String filepath) {
        if (filepath.endsWith(".json")) {
            return "json";
        } else if (filepath.endsWith(".yml") || filepath.endsWith(".yaml")) {
            return "yml";
        }
        return "unknown";
    }
}
