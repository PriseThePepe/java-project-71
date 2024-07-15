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
        switch (mapperType){
            case "json": {
                ObjectMapper objectMapper = new JsonMapper();

                parsedMap = objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {
                });
                break;
            }
            case "yml", "yaml":{
                ObjectMapper yamlMapper = new YAMLMapper();

                parsedMap = yamlMapper.readValue(content, new TypeReference<Map<String, Object>>() {
                });
                break;
            }
            default: throw new IOException("Unknown mapper " + mapperType);
        }
        return parsedMap;
    }

}

