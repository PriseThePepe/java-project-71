package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Collection;
import java.util.Map;

public class JsonFormatter {
    public static String jsonFormat(Map<String, Map<String, Object>> diffMap) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Collection<Map<String, Object>> diffValues = diffMap.values();

        return  objectMapper.writeValueAsString(diffValues);
    }
}
