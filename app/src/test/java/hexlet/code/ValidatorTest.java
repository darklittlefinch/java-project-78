package hexlet.code;

import hexlet.code.schemas.StringSchema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {
    private StringSchema stringSchema;

    @BeforeEach
    void beforeEach() {
        Validator validator = new Validator();
        stringSchema = validator.string();
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

}
