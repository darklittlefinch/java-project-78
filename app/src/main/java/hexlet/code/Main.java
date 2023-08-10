//package hexlet.code;
//
//import hexlet.code.schemas.MapSchema;
//import hexlet.code.schemas.StringSchema;
//import hexlet.code.schemas.NumberSchema;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Main {
//    public static void main(String[] args) {
//
//        // String schema test
//        System.out.println("STRINGS");
//        Validator validator1 = new Validator();
//        StringSchema stringSchema = validator1.string();
//
//        System.out.println("\nDEFAULT CHECK");
//        System.out.println(stringSchema.isValid(null));
//        System.out.println(stringSchema.isValid(""));
//        System.out.println(stringSchema.isValid("fox"));
//        System.out.println(stringSchema.isValid("what does the fox say"));
//
//        System.out.println("\nREQUIRED CHECK");
//        stringSchema.required();
//        System.out.println(stringSchema.isValid(null));
//        System.out.println(stringSchema.isValid(""));
//        System.out.println(stringSchema.isValid("fox"));
//        System.out.println(stringSchema.isValid("what does the fox say"));
//
//        System.out.println("\nMIN LENGTH CHECK");
//        stringSchema.minLength(3);
//        System.out.println(stringSchema.isValid(null));
//        System.out.println(stringSchema.isValid(""));
//        System.out.println(stringSchema.isValid("fox"));
//        System.out.println(stringSchema.isValid("what does the fox say"));
//
//        System.out.println("\nCONTAINS CHECK");
//        stringSchema.contains("fox");
//        System.out.println(stringSchema.isValid(null));
//        System.out.println(stringSchema.isValid(""));
//        System.out.println(stringSchema.isValid("fox"));
//        System.out.println(stringSchema.isValid("what does the fox say"));
//
//        // number schema test
//        System.out.println("\n\nNUMBERS");
//        Validator validator2 = new Validator();
//        NumberSchema numberSchema = validator2.number();
//
//        System.out.println("\nDEFAULT CHECK");
//        System.out.println(numberSchema.isValid(null));
//        System.out.println(numberSchema.isValid(10));
//        System.out.println(numberSchema.isValid(-10));
//        System.out.println(numberSchema.isValid("10"));
//
//        System.out.println("\nREQUIRED CHECK");
//        numberSchema.required();
//        System.out.println(numberSchema.isValid(null));
//        System.out.println(numberSchema.isValid(10));
//        System.out.println(numberSchema.isValid(-10));
//        System.out.println(numberSchema.isValid("10"));
//
//        System.out.println("\nPOSITIVE CHECK");
//        numberSchema.positive();
//        System.out.println(numberSchema.isValid(null));
//        System.out.println(numberSchema.isValid(10));
//        System.out.println(numberSchema.isValid(-10));
//        System.out.println(numberSchema.isValid("10"));
//
//        System.out.println("\nRANGE CHECK");
//        numberSchema.range(-10, 0);
//        System.out.println(numberSchema.isValid(null));
//        System.out.println(numberSchema.isValid(10));
//        System.out.println(numberSchema.isValid(-10));
//        System.out.println(numberSchema.isValid("10"));
//
//        Map<String, String> map1 = Map.of(
//                "key1",
//                "value1",
//                "key2",
//                "value2",
//                "key3",
//                "value3"
//        );
//        Map<Integer, Integer> map2 = Map.of(
//                1,
//                123,
//                2,
//                456
//        );
//
//        // map schema test
//        System.out.println("\n\nMAPS");
//        Validator validator3 = new Validator();
//        MapSchema mapSchema = validator3.map();
//
//        System.out.println("\nDEFAULT CHECK");
//        System.out.println(mapSchema.isValid(map1));
//        System.out.println(mapSchema.isValid(map2));
//        System.out.println(mapSchema.isValid(null));
//        System.out.println(mapSchema.isValid(new HashMap<>()));
//
//        System.out.println("\nREQUIRED CHECK");
//        mapSchema.required();
//
//        System.out.println(mapSchema.isValid(map1));
//        System.out.println(mapSchema.isValid(map2));
//        System.out.println(mapSchema.isValid(null));
//        System.out.println(mapSchema.isValid(new HashMap<>()));
//
//        System.out.println("\nSIZE OF CHECK");
//        mapSchema.sizeOf(2);
//
//        System.out.println(mapSchema.isValid(map1));
//        System.out.println(mapSchema.isValid(map2));
//        System.out.println(mapSchema.isValid(null));
//        System.out.println(mapSchema.isValid(new HashMap<>()));
//
//    }
//}
