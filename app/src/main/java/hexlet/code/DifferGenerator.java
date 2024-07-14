package hexlet.code.DifferGenerator;

import java.util.Objects;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.LinkedHashMap;

public class DifferGenerator {
    public static Map<String, Map<String, Object>> getDiff(Map<String, Object> fileMap1, Map<String, Object> fileMap2) {

        Map<String, Map<String, Object>> diffMap = new LinkedHashMap<>();

        List<String> sortedList = new ArrayList<>(fileMap1.keySet());
        sortedList.addAll(fileMap2.keySet());

        sortedList = sortedList.stream()
                .distinct()
                .sorted()
                .toList();

        for (String key : sortedList) {
            var value1 = fileMap1.get(key);
            var value2 = fileMap2.get(key);

            Map<String, Object> diffMapEntry = new LinkedHashMap<>();

            diffMapEntry.put("key", key);
            if (fileMap1.containsKey(key) && fileMap2.containsKey(key)) {
                if (!Objects.equals(value1, value2)) {
                    diffMapEntry.put("old value", value1);
                    diffMapEntry.put("new value", value2);
                    diffMapEntry.put("status", "updated");
                } else {
                    diffMapEntry.put("old value", value1);
                    diffMapEntry.put("status", "unchanged");
                }
            } else if (fileMap1.containsKey(key)) {
                diffMapEntry.put("old value", value1);
                diffMapEntry.put("status", "removed");
            } else {
                diffMapEntry.put("new value", value2);
                diffMapEntry.put("status", "added");
            }
            diffMap.put(key, diffMapEntry);
        }
        return diffMap;
    }
}
