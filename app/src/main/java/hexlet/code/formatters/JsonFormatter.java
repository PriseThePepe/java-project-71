package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import hexlet.code.Status;
import hexlet.code.StatusSerializer;

import java.util.Collection;
import java.util.Map;

public class JsonFormatter {
    public static String jsonFormat(Map<String, Status> diffMap) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Status.class, new StatusSerializer());
        objectMapper.registerModule(module);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Collection<Status> diffValues = diffMap.values();

        return  objectMapper.writeValueAsString(diffValues);
    }
}
