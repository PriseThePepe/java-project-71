package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String content, String mapperType) throws IOException {

        return switch (mapperType) {
            case "json" -> {
                ObjectMapper objectMapper = new JsonMapper();

                yield objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {
                });
            }
            case "yml", "yaml" -> {
                ObjectMapper yamlMapper = new YAMLMapper();

                yield yamlMapper.readValue(content, new TypeReference<Map<String, Object>>() {
                });
            }
            default -> throw new IOException("Unknown mapper " + mapperType);
        };
    }
}
