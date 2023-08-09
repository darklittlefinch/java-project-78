package hexlet.code;

import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;

public class Main {
    public static void main(String[] args) {

        // String schema test
        System.out.println("STRINGS");
        Validator validator1 = new Validator();
        StringSchema stringSchema = validator1.string();

        System.out.println("\nDEFAULT CHECK");
        System.out.println(stringSchema.isValid(null));
        System.out.println(stringSchema.isValid(""));
        System.out.println(stringSchema.isValid("fox"));
        System.out.println(stringSchema.isValid("what does the fox say"));

        System.out.println("\nREQUIRED CHECK");
        stringSchema.required();
        System.out.println(stringSchema.isValid(null));
        System.out.println(stringSchema.isValid(""));
        System.out.println(stringSchema.isValid("fox"));
        System.out.println(stringSchema.isValid("what does the fox say"));

        System.out.println("\nMIN LENGTH CHECK");
        stringSchema.minLength(3);
        System.out.println(stringSchema.isValid(null));
        System.out.println(stringSchema.isValid(""));
        System.out.println(stringSchema.isValid("fox"));
        System.out.println(stringSchema.isValid("what does the fox say"));

        System.out.println("\nCONTENTS CHECK");
        stringSchema.contains("fox");
        System.out.println(stringSchema.isValid(null));
        System.out.println(stringSchema.isValid(""));
        System.out.println(stringSchema.isValid("fox"));
        System.out.println(stringSchema.isValid("what does the fox say"));

        // number schema test
        System.out.println("\n\nNUMBERS");
        Validator validator2 = new Validator();
        NumberSchema numberSchema = validator2.number();

        System.out.println("\nDEFAULT CHECK");
        System.out.println(numberSchema.isValid(null));
        System.out.println(numberSchema.isValid(10));
        System.out.println(numberSchema.isValid(-10));
        System.out.println(numberSchema.isValid("10"));

        System.out.println("\nREQUIRED CHECK");
        numberSchema.required();
        System.out.println(numberSchema.isValid(null));
        System.out.println(numberSchema.isValid(10));
        System.out.println(numberSchema.isValid(-10));
        System.out.println(numberSchema.isValid("10"));

        System.out.println("\nPOSITIVE CHECK");
        numberSchema.positive();
        System.out.println(numberSchema.isValid(null));
        System.out.println(numberSchema.isValid(10));
        System.out.println(numberSchema.isValid(-10));
        System.out.println(numberSchema.isValid("10"));

        System.out.println("\nRANGE CHECK");
        numberSchema.range(-10, 0);
        System.out.println(numberSchema.isValid(null));
        System.out.println(numberSchema.isValid(10));
        System.out.println(numberSchema.isValid(-10));
        System.out.println(numberSchema.isValid("10"));
    }
}
