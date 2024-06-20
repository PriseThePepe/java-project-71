package hexlet.code;

import hexlet.code.Parser.Parser;

import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Differ {
    public static String generate(String firstFilepath, String secondFilepath) throws IOException {
        Path firstPath = Paths.get(firstFilepath).toAbsolutePath();
        Path secondPath = Paths.get(secondFilepath).toAbsolutePath();

/*
        File firstFile = new File(String.valueOf(firstPath));
        File secondFile = new File(String.valueOf(secondPath));
*/

        String result;
       Map<String, Object> parsedFirstFile =  Parser.parse(firstFilepath);
       Map<String, Object> parsedSecondFile = Parser.parse(secondFilepath);

       result = getDiff(parsedFirstFile,parsedSecondFile);

      return result;
    }
    public static String getDiff(Map<String, Object> fileMap1, Map<String, Object> fileMap2) {

        StringBuilder builder = new StringBuilder();
        Map<String,Map<String,Object>> diffMap = new LinkedHashMap<>();

        List<String> sortedList = new ArrayList<>(fileMap1.keySet());
        sortedList.addAll(fileMap2.keySet());

        sortedList = sortedList.stream()
                .distinct()
                .sorted()
                .toList();

        builder.append("{").append(System.lineSeparator());

        for (String key : sortedList) {
            var value1 = fileMap1.get(key);
            var value2 = fileMap2.get(key);

            if (value1 == null) {
                builder.append("  ").append("+ ")
                        .append(key).append(": ").append(value2).
                        append(System.lineSeparator());
            } else if (value2 == null) {
                builder.append("  ").append("- ").
                        append(key).append(": ").append(value1)
                        .append(System.lineSeparator());
            } else if (value1.equals(value2)) {
                builder.append("    ").
                        append(key).append(": ").append(value1)
                        .append(System.lineSeparator());
            } else {
                builder.append("  ").append("- ")
                        .append(key).append(": ").append(value1)
                        .append(System.lineSeparator());
                builder.append("  ").append("+ ")
                        .append(key).append(": ").append(value2)
                        .append(System.lineSeparator());
            }
        }

        builder.append("}");

        return builder.toString();
    }

}
