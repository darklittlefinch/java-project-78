package hexlet.code;

import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {
    private StringSchema stringSchema;
    private NumberSchema numberSchema;

    @BeforeEach
    void beforeEach() {
        Validator validator = new Validator();
        stringSchema = validator.string();
        numberSchema = validator.number();
    }

    @Test
    void stringSchemaTestDefault() {
        assertThat(stringSchema.isValid(null)).isEqualTo(true);
        assertThat(stringSchema.isValid("")).isEqualTo(true);
        assertThat(stringSchema.isValid("fox")).isEqualTo(true);
        assertThat(stringSchema.isValid("what does the fox say")).isEqualTo(true);
    }

    @Test
    void stringSchemaTestRequired() {
        stringSchema.required();

        assertThat(stringSchema.isValid(null)).isEqualTo(false);
        assertThat(stringSchema.isValid("")).isEqualTo(false);
        assertThat(stringSchema.isValid("fox")).isEqualTo(true);
        assertThat(stringSchema.isValid("what does the fox say")).isEqualTo(true);
    }

    @Test
    void stringSchemaTestMinLength() {
        stringSchema.minLength(5);

        assertThat(stringSchema.isValid(null)).isEqualTo(false);
        assertThat(stringSchema.isValid("")).isEqualTo(false);
        assertThat(stringSchema.isValid("fox")).isEqualTo(false);
        assertThat(stringSchema.isValid("what does the fox say")).isEqualTo(true);

        stringSchema.minLength(3);

        assertThat(stringSchema.isValid("fox")).isEqualTo(true);
    }

    @Test
    void stringSchemaTestContains() {
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
        assertThat(numberSchema.isValid(null)).isEqualTo(true);
        assertThat(numberSchema.isValid(10)).isEqualTo(true);
        assertThat(numberSchema.isValid(-10)).isEqualTo(true);
        assertThat(numberSchema.isValid("10")).isEqualTo(false);
    }

    @Test
    void numberSchemaTestRequired() {
        numberSchema.required();

        assertThat(numberSchema.isValid(null)).isEqualTo(false);
        assertThat(numberSchema.isValid(10)).isEqualTo(true);
        assertThat(numberSchema.isValid(-10)).isEqualTo(true);
        assertThat(numberSchema.isValid("10")).isEqualTo(false);
    }

    @Test
    void numberSchemaTestPositive() {
        numberSchema.positive();

        assertThat(numberSchema.isValid(null)).isEqualTo(false);
        assertThat(numberSchema.isValid(10)).isEqualTo(true);
        assertThat(numberSchema.isValid(-10)).isEqualTo(false);
        assertThat(numberSchema.isValid("10")).isEqualTo(false);
    }

    @Test
    void numberSchemaTestRange() {
        numberSchema.range(-10, 0);

        assertThat(numberSchema.isValid(null)).isEqualTo(false);
        assertThat(numberSchema.isValid(10)).isEqualTo(false);
        assertThat(numberSchema.isValid(-10)).isEqualTo(true);
        assertThat(numberSchema.isValid("10")).isEqualTo(false);
    }

    @Test
    void numberSchemaTestAllMethods() {
        numberSchema.required();
        numberSchema.positive();
        numberSchema.range(-10, 0);

        assertThat(numberSchema.isValid(null)).isEqualTo(false);
        assertThat(numberSchema.isValid(10)).isEqualTo(false);
        assertThat(numberSchema.isValid(-10)).isEqualTo(false);
        assertThat(numberSchema.isValid("10")).isEqualTo(false);
    }
}
