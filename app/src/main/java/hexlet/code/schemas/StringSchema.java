package hexlet.code.schemas;

import java.util.LinkedHashMap;

public class StringSchema extends BaseSchema {

    private static final String DATA_TYPE = "dataType";
    private static final String REQUIRED = "required";
    private static final String MIN_LENGTH = "minLength";
    private static final String CONTAINS = "contains";

    public StringSchema() {
        checks = new LinkedHashMap<>();
        addCheck(DATA_TYPE, value -> (value instanceof String) || value == null);
    }

    public void required() {
        addCheck(REQUIRED, value -> (value instanceof String) && (!value.equals("")));
    }

    public void minLength(int number) {
        addCheck(MIN_LENGTH, value -> (value == null) || (value.toString().length() >= number));
    }

    public void contains(String string) {
        addCheck(CONTAINS, value -> (value != null) && (value.toString().contains(string)));
    }

}
