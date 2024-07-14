package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.List;
import java.util.Map;

public class PlainFormatter {
    public static String plainFormat(Map<String, Status> diffMap) {
        StringBuilder builder = new StringBuilder();

        for (Status status : diffMap.values()) {

            switch (status.getStatusName()) {
                case Status.REMOVED ->
                        builder.append("Property ").
                                append("'").
                                append(status.getKey()).
                                append("'").
                                append(" was removed").
                                append(System.lineSeparator());
                case Status.ADDED ->
                        builder.append("Property ").
                                append("'").
                                append(status.getKey()).
                                append("'").
                                append(" was added with value: ").
                                append(formatValue(status.getNewValue())).
                                append(System.lineSeparator());
                case Status.UNCHANGED -> {
                }
                case Status.UPDATED -> builder.append("Property ").
                        append("'").
                        append(status.getKey()).
                        append("'").
                        append(" was updated.").
                        append(" From ").
                        append(formatValue(status.getOldValue())).
                        append(" to ").
                        append(formatValue(status.getNewValue())).
                        append(System.lineSeparator());
                default -> throw new RuntimeException("Unknown status: +" + status);
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
