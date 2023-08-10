package hexlet.code.schemas;

import java.util.LinkedHashMap;

public class StringSchema extends BaseSchema {

    private static final String DATA_TYPE = "dataType";
    private static final String REQUIRED = "required";
    private static final String MIN_LENGTH = "minLength";
    private static final String CONTAINS = "contains";

    private int minLengthNumber;
    private String content;

    public StringSchema() {
        addCheck(DATA_TYPE, value -> (value instanceof String) || value == null);
    }

    public void required() {
        addCheck(REQUIRED, value -> (value instanceof String) && (!value.equals("")));
    }

    public void minLength(int number) {
        minLengthNumber = number;
        addCheck(MIN_LENGTH, value -> (value == null) || (value.toString().length() >= minLengthNumber));
    }

    public void contains(String string) {
        content = string;
        addCheck(CONTAINS, value -> (value != null) && (value.toString().contains(content)));
    }

}
