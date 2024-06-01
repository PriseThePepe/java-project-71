package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String firstFilepath, String secondFilepath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Path firstPath = Paths.get(firstFilepath).toAbsolutePath();
        Path secondPath = Paths.get(secondFilepath).toAbsolutePath();

        File firstJson = new File(String.valueOf(firstPath));
        File secondJson = new File(String.valueOf(secondPath));

        Map<String, String> jsonMap1 = objectMapper.readValue(firstJson, new TypeReference<Map<String, String>>() {
        });
        Map<String, String> jsonMap2 = objectMapper.readValue(secondJson, new TypeReference<Map<String, String>>() {
        });

        return getJsonDiff(jsonMap1, jsonMap2);
    }

    private static String getJsonDiff(Map<String, String> jsonMap1, Map<String, String> jsonMap2) {
        StringBuilder builder = new StringBuilder();

        List<String> sortedList = new ArrayList<>(jsonMap1.keySet());
        sortedList.addAll(jsonMap2.keySet());

        sortedList = sortedList.stream()
                .distinct()
                .sorted()
                .toList();
        for (String key : sortedList) {
            String value1 = jsonMap1.get(key);
            String value2 = jsonMap2.get(key);

            if (value1 == null) {
                builder.append("+ ").append(key).append(": ").append(value2).append(System.lineSeparator());
            } else if (value2 == null) {
                builder.append("- ").append(key).append(": ").append(value1).append(System.lineSeparator());
            } else if (value1.equals(value2)) {
                builder.append("  ").append(key).append(": ").append(value1).append(System.lineSeparator());
            } else {
                builder.append("- ").append(key).append(": ").append(value1).append(System.lineSeparator());
                builder.append("+ ").append(key).append(": ").append(value2).append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
