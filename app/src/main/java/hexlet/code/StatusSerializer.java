package hexlet.code;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public final class StatusSerializer extends StdSerializer<Status> {

    public StatusSerializer() {
        this(null);
    }

    public StatusSerializer(Class<Status> t) {
        super(t);
    }

    @Override
    public void serialize(Status status, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("key", status.getKey());
        switch (status.getStatusName()) {
            case Status.REMOVED, Status.UNCHANGED ->
                    jsonGenerator.writeObjectField("old value", status.getOldValue());
            case Status.ADDED ->
                    jsonGenerator.writeObjectField("new value", status.getNewValue());
            case Status.UPDATED -> {
                jsonGenerator.writeObjectField("old value", status.getOldValue());
                jsonGenerator.writeObjectField("new value", status.getNewValue());
            }
            default -> throw new RuntimeException("Wrong status name " + status.getStatusName());
        }
        jsonGenerator.writeStringField("status", status.getStatusName());
        jsonGenerator.writeEndObject();
    }
}
