package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.DefaultFormatter;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.Map;

public class Formatter {
    public static String format(Map<String, Map<String, Object>> diffMap, String format)
            throws JsonProcessingException {
        String formatedDiffMap = "";
        switch (format) {
            case ("stylish"):
                formatedDiffMap = StylishFormatter.stylishFormat(diffMap);
                break;
            case ("default"):
                formatedDiffMap = DefaultFormatter.defaultFormat(diffMap);
                break;
            case("plain"):
                formatedDiffMap = PlainFormatter.plainFormat(diffMap);
                break;
            case ("json"):
                formatedDiffMap = JsonFormatter.jsonFormat(diffMap);
                break;
            default:
                System.err.println("Error: Invalid format "
                        +
                        format
                        +
                        " Please enter a legal format");
                break;
        }
        return formatedDiffMap;
    }
}
