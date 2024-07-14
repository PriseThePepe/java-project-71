package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.Map;

public class StylishFormatter {
    public static String stylishFormat(Map<String, Status> diffMap) {
        StringBuilder builder = new StringBuilder();

        builder.append("{").append(System.lineSeparator());

        for (Status status : diffMap.values()) {

            switch (status.getStatusName()) {
                case Status.REMOVED ->
                        builder.append("  - ").
                                append(status.getKey()).
                                append(": ").
                                append(status.getOldValue()).
                                append(System.lineSeparator());
                case Status.ADDED ->
                        builder.append("  + ").
                                append(status.getKey()).
                                append(": ").
                                append(status.getNewValue()).
                                append(System.lineSeparator());
                case Status.UNCHANGED ->
                        builder.append("    ").
                                append(status.getKey()).
                                append(": ").
                                append(status.getOldValue()).
                                append(System.lineSeparator());
                default -> {
                    builder.append("  - ").
                            append(status.getKey()).
                            append(": ").
                            append(status.getOldValue()).
                            append(System.lineSeparator());

                    builder.append("  + ").
                            append(status.getKey()).
                            append(": ").
                        append(status.getNewValue()).
                        append(System.lineSeparator());
                }
            }
        }
        builder.append("}").append(System.lineSeparator());
        return builder.toString().trim();

    }
}


