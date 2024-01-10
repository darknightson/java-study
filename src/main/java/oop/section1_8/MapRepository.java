package oop.section1_8;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapRepository {

    private final Map<String, String> map = new HashMap<>();

    public MapRepository() {
        map.put("key1", "value1");
    }

    public String getValue(String key) {
        return map.get(key);
    }

    public Optional<String> getOptionalValue(String key) {
        return Optional.ofNullable(map.get(key));
    }
}
