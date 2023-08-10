package hexlet.code.schemas;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected Map<String, Predicate> checks;

    public BaseSchema() {
        checks = new LinkedHashMap<>();
    }

    public boolean isValid(Object value) {

        for (Predicate validate : checks.values()) {
            if (!validate.test(value)) {
                return false;
            }
        }
        return true;
    }

    public void addCheck(String value, Predicate check) {
        checks.put(value, check);
    }
}
