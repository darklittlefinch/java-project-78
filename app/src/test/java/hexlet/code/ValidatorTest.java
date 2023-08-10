package hexlet.code;

import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {
    private static final Map<String, String> MAP_1 = Map.of(
            "key1",
            "value1",
            "key2",
            "value2",
            "key3",
            "value3"
    );
    private static final Map<Integer, Integer> MAP_2 = Map.of(
            1,
            123,
            2,
            456
    );

    private Validator validator;
    private StringSchema stringSchema;
    private NumberSchema numberSchema;
    private MapSchema mapSchema;

    @BeforeEach
    void beforeEach() {
        validator = new Validator();
    }

    @Test
    void stringSchemaTestDefault() {
        stringSchema = validator.string();

        assertThat(stringSchema.isValid(null)).isEqualTo(true);
        assertThat(stringSchema.isValid("")).isEqualTo(true);
        assertThat(stringSchema.isValid("fox")).isEqualTo(true);
        assertThat(stringSchema.isValid("what does the fox say")).isEqualTo(true);
    }

    @Test
    void stringSchemaTestRequired() {
        stringSchema = validator.string();

        stringSchema.required();

        assertThat(stringSchema.isValid(null)).isEqualTo(false);
        assertThat(stringSchema.isValid("")).isEqualTo(false);
        assertThat(stringSchema.isValid("fox")).isEqualTo(true);
        assertThat(stringSchema.isValid("what does the fox say")).isEqualTo(true);
    }

    @Test
    void stringSchemaTestMinLength() {
        stringSchema = validator.string();

        stringSchema.minLength(5);

        assertThat(stringSchema.isValid(null)).isEqualTo(true);
        assertThat(stringSchema.isValid("")).isEqualTo(false);
        assertThat(stringSchema.isValid("fox")).isEqualTo(false);
        assertThat(stringSchema.isValid("what does the fox say")).isEqualTo(true);

        stringSchema.minLength(3);

        assertThat(stringSchema.isValid("fox")).isEqualTo(true);
    }

    @Test
    void stringSchemaTestContains() {
        stringSchema = validator.string();

        stringSchema.contains("fox");

        assertThat(stringSchema.isValid(null)).isEqualTo(false);
        assertThat(stringSchema.isValid("")).isEqualTo(false);
        assertThat(stringSchema.isValid("fox")).isEqualTo(true);
        assertThat(stringSchema.isValid("what does the fox say")).isEqualTo(true);

        stringSchema.contains("what");

        assertThat(stringSchema.isValid("fox")).isEqualTo(false);
        assertThat(stringSchema.isValid("what does the fox say")).isEqualTo(true);

        stringSchema.contains("something else");

        assertThat(stringSchema.isValid("what does the fox say")).isEqualTo(false);
    }

    @Test
    void stringSchemaTestAllMethods() {
        stringSchema = validator.string();

        stringSchema.required();
        stringSchema.minLength(5);

        assertThat(stringSchema.isValid(null)).isEqualTo(false);
        assertThat(stringSchema.isValid("")).isEqualTo(false);
        assertThat(stringSchema.isValid("fox")).isEqualTo(false);
        assertThat(stringSchema.isValid("what does the fox say")).isEqualTo(true);

        stringSchema.contains("fox");

        assertThat(stringSchema.isValid("fox")).isEqualTo(false);
        assertThat(stringSchema.isValid("what does the fox say")).isEqualTo(true);
    }

    @Test
    void numberSchemaTestDefault() {
        numberSchema = validator.number();

        assertThat(numberSchema.isValid(null)).isEqualTo(true);
        assertThat(numberSchema.isValid(10)).isEqualTo(true);
        assertThat(numberSchema.isValid(-10)).isEqualTo(true);
        assertThat(numberSchema.isValid("10")).isEqualTo(false);
    }

    @Test
    void numberSchemaTestRequired() {
        numberSchema = validator.number();

        numberSchema.required();

        assertThat(numberSchema.isValid(null)).isEqualTo(false);
        assertThat(numberSchema.isValid(10)).isEqualTo(true);
        assertThat(numberSchema.isValid(-10)).isEqualTo(true);
        assertThat(numberSchema.isValid("10")).isEqualTo(false);
    }

    @Test
    void numberSchemaTestPositive() {
        numberSchema = validator.number();

        numberSchema.positive();

        assertThat(numberSchema.isValid(null)).isEqualTo(true);
        assertThat(numberSchema.isValid(10)).isEqualTo(true);
        assertThat(numberSchema.isValid(-10)).isEqualTo(false);
        assertThat(numberSchema.isValid("10")).isEqualTo(false);
    }

    @Test
    void numberSchemaTestRange() {
        numberSchema = validator.number();

        numberSchema.range(-10, 0);

        assertThat(numberSchema.isValid(null)).isEqualTo(true);
        assertThat(numberSchema.isValid(10)).isEqualTo(false);
        assertThat(numberSchema.isValid(-10)).isEqualTo(true);
        assertThat(numberSchema.isValid("10")).isEqualTo(false);
    }

    @Test
    void numberSchemaTestAllMethods() {
        numberSchema = validator.number();

        numberSchema.required();
        numberSchema.positive();
        numberSchema.range(-10, 0);

        assertThat(numberSchema.isValid(null)).isEqualTo(false);
        assertThat(numberSchema.isValid(10)).isEqualTo(false);
        assertThat(numberSchema.isValid(-10)).isEqualTo(false);
        assertThat(numberSchema.isValid("10")).isEqualTo(false);
    }

    @Test
    void mapSchemaTestDefault() {
        mapSchema = validator.map();

        assertThat(mapSchema.isValid(null)).isEqualTo(true);
        assertThat(mapSchema.isValid(new HashMap<>())).isEqualTo(true);
        assertThat(mapSchema.isValid(MAP_1)).isEqualTo(true);
        assertThat(mapSchema.isValid(MAP_2)).isEqualTo(true);
    }

    @Test
    void mapSchemaTestRequired() {
        mapSchema = validator.map();
        mapSchema.required();

        assertThat(mapSchema.isValid(null)).isEqualTo(false);
        assertThat(mapSchema.isValid(new HashMap<>())).isEqualTo(true);
        assertThat(mapSchema.isValid(MAP_1)).isEqualTo(true);
        assertThat(mapSchema.isValid(MAP_2)).isEqualTo(true);
    }

    @Test
    void mapSchemaTestSizeOf() {
        mapSchema = validator.map();
        mapSchema.sizeOf(2);

        assertThat(mapSchema.isValid(null)).isEqualTo(true);
        assertThat(mapSchema.isValid(new HashMap<>())).isEqualTo(false);
        assertThat(mapSchema.isValid(MAP_1)).isEqualTo(false);
        assertThat(mapSchema.isValid(MAP_2)).isEqualTo(true);
    }

    @Test
    void mapSchemaTestShape() {
        mapSchema = validator.map();
        mapSchema.sizeOf(2);

        assertThat(mapSchema.isValid(null)).isEqualTo(true);
        assertThat(mapSchema.isValid(new HashMap<>())).isEqualTo(false);
        assertThat(mapSchema.isValid(MAP_1)).isEqualTo(false);
        assertThat(mapSchema.isValid(MAP_2)).isEqualTo(true);
    }

    @Test
    void mapSchemaTestAllMethods() {
        mapSchema = validator.map();
        mapSchema.required();
        mapSchema.sizeOf(2);

        assertThat(mapSchema.isValid(null)).isEqualTo(false);
        assertThat(mapSchema.isValid(new HashMap<>())).isEqualTo(false);
        assertThat(mapSchema.isValid(MAP_1)).isEqualTo(false);
        assertThat(mapSchema.isValid(MAP_2)).isEqualTo(true);
    }
}
