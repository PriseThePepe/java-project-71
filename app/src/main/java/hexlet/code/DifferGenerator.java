package hexlet.code;

import java.util.TreeSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class DifferGenerator {
    public static Map<String, Status> getDiff(Map<String, Object> fileMap1, Map<String, Object> fileMap2) {

        Map<String, Status> diffMap = new LinkedHashMap<>();

        TreeSet<String> treeSet = new TreeSet<>(fileMap1.keySet());
        treeSet.addAll(fileMap2.keySet());

        for (String key : treeSet) {
            var value1 = fileMap1.get(key);
            var value2 = fileMap2.get(key);

            Status status = null;
            if (!fileMap1.containsKey(key)) {
                status = new Status(Status.ADDED, key, null, value2);
            } else if (!fileMap2.containsKey(key)) {
                status = new Status(Status.REMOVED, key, value1, null);
            } else if (Objects.equals(fileMap1.get(key), fileMap2.get(key))) {
                status = new Status(Status.UNCHANGED, key, value1, null);
            } else if (!Objects.equals(fileMap1.get(key), fileMap2.get(key))) {
                status = new Status(Status.UPDATED, key, value1, value2);
            }
            diffMap.put(key, status);
        }
        return diffMap;
    }
}
