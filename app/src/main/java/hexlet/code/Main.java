package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class Main {
    public static void main(String[] args) {
        Validator validator = new Validator();
        StringSchema stringSchema = validator.string();

        System.out.println("DEFAULT CHECK");
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
        stringSchema.minLength(5);
        System.out.println(stringSchema.isValid(null));
        System.out.println(stringSchema.isValid(""));
        System.out.println(stringSchema.isValid("fox"));
        System.out.println(stringSchema.isValid("what does the fox say"));

        System.out.println("\nCONTENTS CHECK");
        stringSchema.contains("what");
        System.out.println(stringSchema.isValid(null));
        System.out.println(stringSchema.isValid(""));
        System.out.println(stringSchema.isValid("fox"));
        System.out.println(stringSchema.isValid("what does the fox say"));
    }
}
