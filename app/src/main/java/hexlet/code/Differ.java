package hexlet.code;

import hexlet.code.DifferGenerator.DifferGenerator;
import hexlet.code.Parser.Parser;

import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Map;

public class Differ {
    public static String generate(String firstFilepath, String secondFilepath, String format) throws IOException {
        Path firstPath = Paths.get(firstFilepath).toAbsolutePath();
        Path secondPath = Paths.get(secondFilepath).toAbsolutePath();

        String result;
        Map<String, Object> parsedFirstFile =  Parser.parse(String.valueOf(firstPath));
        Map<String, Object> parsedSecondFile = Parser.parse(String.valueOf(secondPath));

        Map<String, Map<String, Object>> diffMap = DifferGenerator.getDiff(parsedFirstFile, parsedSecondFile);

        result = Formatter.format(diffMap, format);

        return result;
    }
}
