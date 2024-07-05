package hexlet.code.Parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filepath) throws IOException {
        Path path = Paths.get(filepath).toAbsolutePath();

        File file = new File(String.valueOf(path));

        Map<String, Object> parsedMap = null;

        if (getFileExtension(filepath).equals(".json")) {
            ObjectMapper objectMapper = new JsonMapper();

            parsedMap = objectMapper.readValue(file, new TypeReference<Map<String, Object>>() {
            });
        } else if (getFileExtension(filepath).equals(".yaml")) {
            ObjectMapper yamlMapper = new YAMLMapper();

            parsedMap = yamlMapper.readValue(file, new TypeReference<Map<String, Object>>() {
            });
        }
        return parsedMap;
    }
    private static String getFileExtension(String filepath) {
        int index = filepath.indexOf('.');
        return index == -1 ? ".none" : filepath.substring(index);
    }
}

