package hexlet.code.schemas;

import java.util.LinkedHashMap;

public class NumberSchema extends BaseSchema {

    private static final String DATA_TYPE = "dataType";
    private static final String REQUIRED = "required";
    private static final String POSITIVE = "positive";
    private static final String RANGE = "range";

    public NumberSchema() {
        checks = new LinkedHashMap<>();
        addCheck(DATA_TYPE, value -> (value instanceof Integer) || (value == null));
    }

    public void required() {
        addCheck(REQUIRED, value -> value instanceof Integer);
    }

    public void positive() {
        addCheck(POSITIVE, value -> (value == null) || ((int) value > 0));
    }

    public void range(Integer first, Integer last) {
        addCheck(RANGE, value -> (value == null) || ((int) value >= first && (int) value <= last));
    }

}
