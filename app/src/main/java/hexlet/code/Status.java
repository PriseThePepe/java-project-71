package hexlet.code;

public final class Status {
    public static final String REMOVED = "removed";
    public static final String ADDED = "added";
    public static final String UNCHANGED = "unchanged";
    public static final String UPDATED = "updated";

    private final String statusName;
    private final String key;
    private final Object oldValue;
    private final Object newValue;


    Status(String statusName, String key, Object oldValue, Object newValue) {
        this.statusName = statusName;
        this.key = key;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public String getStatusName() {
        return statusName;
    }

    public String getKey() {
        return key;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

}
