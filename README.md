## Instructions

To use it, build the project:
```shell
mvn clean install
```

Select a project containing as fully qualified name `dev.snowdrop.demo.FooBar` and execute the command:
```shell
mvn -U org.openrewrite.maven:rewrite-maven-plugin:run \
  -Drewrite.recipeArtifactCoordinates=dev.snowdrop:openrewrite-rules:1.0-SNAPSHOT \
  -Drewrite.activeRecipes=dev.snowdrop.SayHelloRecipe
```
When done, check if openrewrite added a Hello method
```java
  package dev.snowdrop.demo
  class FooBar {
      public String hello() {
          return "Hello from dev.snowdrop.demo.FooBar!";
      }
  }
```

## Issue

TODO