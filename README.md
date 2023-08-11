# Data Validator

### Hexlet tests and linter status:
[![Actions Status](https://github.com/darklittlefinch/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/darklittlefinch/java-project-78/actions)
[![Actions Status](https://github.com/darklittlefinch/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/darklittlefinch/java-project-78/actions/workflow/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/3c796b40089ee57f1ffc/maintainability)](https://codeclimate.com/github/darklittlefinch/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/3c796b40089ee57f1ffc/test_coverage)](https://codeclimate.com/github/darklittlefinch/java-project-78/test_coverage)

__Data Validator__ is a Java library that helps you to validate some data types. The library supports three data types: Strings, Integers and Maps. To start to work with this just create a new Validator object and choose one of the proposed schemes:

```java
var validator = new Validator();
```

__Warning!__ If you have already chosen a schema, but you want to use another one, create new Validator to avoid type conflicts.

-----
## StringSchema

This schema validate String objects. To choose this schema write:

```java
var schema = validator.string();
```

StringSchema has three validation methods: 
* __required()__ - makes the fields required and limits the possibility to use null or empty String.
* __minLength()__ - adds a minimum length constraint for the String. The String must be equal or longer than a specified number. Requires an integer parameter of minimum length.
* __contains()__ - adds a String content constraint. The String must contain a substring passed in the method parameter.

You can see an example of how StringSchema works here:

[![asciicast](https://asciinema.org/a/Bl4hPj2LqLiSL0AJ7tFOfoyOA.svg)](https://asciinema.org/a/Bl4hPj2LqLiSL0AJ7tFOfoyOA)

-----
## NumberSchema

This schema validate Integer objects. To choose this schema write:

```java
var schema = validator.number();
```

NumberSchema has three validation methods:
* __required()__ - makes the fileds required and limits the possibility to use null.
* __positive()__ - adds a constraint to use negative numbers.
* __range()__ - adds a range constraint (inclusive). Requires two integer parameters of the first and the last numbers of range.

You can see an example of how NumberSchema works here:

[![asciicast](https://asciinema.org/a/Bm7UNNCDByobWnAMzpq7M8CMf.svg)](https://asciinema.org/a/Bm7UNNCDByobWnAMzpq7M8CMf)

-----
## MapSchema

This schema validate Map objects. To schoose this schema write:

```java
var schema = validator.map();
```

MapSchema has three validation methods:
* __required()__ - makes the fields required and limits the possibility to use null.
* __sizeOf()__ - adds a map size constraint. The K-V count must be equal to the number passed in the method parameter.
* __shape()__ - adds constraints to map values. Accepts as a parameter a map of keys whose values need to be validated and schemas that would validate the values.

Below is an example of how shape() method works:

```java
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", validator.string().required());
schemas.put("age", validator.number().positive());
schema.shape(schemas);

Map<String, Object> map = new HashMap<>();
map.put("name", "Eliza");
map.put("age", 24);
schema.isValid(map); // true

map.put("name", 123);
schema.isValid(map); // false
```

You can see an example of how MapSchema works here:

[![asciicast](https://asciinema.org/a/naAhNKQgO8qJvuYDi8FgCig1d.svg)](https://asciinema.org/a/naAhNKQgO8qJvuYDi8FgCig1d)


