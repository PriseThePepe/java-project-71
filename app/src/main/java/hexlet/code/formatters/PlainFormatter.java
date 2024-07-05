package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class PlainFormatter {
    public static String plainFormat(Map<String, Map<String, Object>> diffMap) {
        StringBuilder builder = new StringBuilder();

        for (Map<String, Object> diff : diffMap.values()) {
            String status = (String) diff.get("status");

            switch (status) {
                case "removed" ->
                        builder.append("Property ").
                                append("'").
                                append(diff.get("key")).
                                append("'").
                                append(" was removed").
                                append(System.lineSeparator());
                case "added" ->
                        builder.append("Property ").
                                append("'").
                                append(diff.get("key")).
                                append("'").
                                append(" was added with value: ").
                                append(formatValue(diff.get("new value"))).
                                append(System.lineSeparator());
                case "unchanged" -> {
                }
                default -> builder.append("Property ").
                        append("'").
                        append(diff.get("key")).
                        append("'").
                        append(" was updated.").
                        append(" From ").
                        append(formatValue(diff.get("old value"))).
                        append(" to ").
                        append(formatValue(diff.get("new value"))).
                        append(System.lineSeparator());
            }
        }

        return builder.toString().trim();
    }
    private static String formatValue(Object value) {
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        return String.valueOf(value);
    }
}
