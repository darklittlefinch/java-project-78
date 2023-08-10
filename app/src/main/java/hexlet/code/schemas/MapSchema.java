package hexlet.code.schemas;

import java.util.Map;
import java.util.LinkedHashMap;

public class MapSchema extends BaseSchema {
    private static final String DATA_TYPE = "dataType";
    private static final String REQUIRED = "required";
    private static final String SIZE_OF = "sizeOf";

    private int size;

    public MapSchema() {
        checks = new LinkedHashMap<>();
        addCheck(DATA_TYPE, value -> (value instanceof Map) || value == null);
    }

    public void required() {
        addCheck(REQUIRED, value -> value instanceof Map);
    }

    public void sizeOf(int number) {
        size = number;
        addCheck(SIZE_OF, value -> value == null || ((Map) value).size() == size);
    }
}
