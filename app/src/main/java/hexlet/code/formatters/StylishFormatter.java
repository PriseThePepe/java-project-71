package hexlet.code.formatters;

import java.util.Map;

public class StylishFormatter {
    public static String stylishFormat(Map<String, Map<String, Object>> diffMap) {
        StringBuilder builder = new StringBuilder();

        builder.append("{").append(System.lineSeparator());

        for (Map<String, Object> diff : diffMap.values()) {
            String status = (String) diff.get("status");

            switch (status) {
                case "removed" ->
                        builder.append("  - ").
                                append(diff.get("key")).
                                append(": ").
                                append(diff.get("old value")).
                                append(System.lineSeparator());
                case "added" ->
                        builder.append("  + ").
                                append(diff.get("key")).
                                append(": ").
                                append(diff.get("new value")).
                                append(System.lineSeparator());
                case "unchanged" ->
                        builder.append("    ").
                                append(diff.get("key")).
                                append(": ").
                                append(diff.get("old value")).
                                append(System.lineSeparator());
                default -> {
                    builder.append("  - ").
                            append(diff.get("key")).
                            append(": ").
                            append(diff.get("old value")).
                            append(System.lineSeparator());

                    builder.append("  + ").
                            append(diff.get("key")).
                            append(": ").
                        append(diff.get("new value")).
                        append(System.lineSeparator());
                }
            }
        }
        builder.append("}").append(System.lineSeparator());
        return builder.toString();

    }
}


