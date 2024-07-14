package hexlet.code.Parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String content, String mapperType) throws IOException {

        Map<String, Object> parsedMap = null;

        if (mapperType.equals("json")) {
            ObjectMapper objectMapper = new JsonMapper();

            parsedMap = objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {
            });
        } else if (mapperType.equals("yml")) {
            ObjectMapper yamlMapper = new YAMLMapper();

            parsedMap = yamlMapper.readValue(content, new TypeReference<Map<String, Object>>() {
            });
        }
        return parsedMap;
    }

}

