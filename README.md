## Instructions

To use it, build the project:
```shell
mvn clean install
```

Select a project containing as fully qualified name `dev.snowdrop.demo.FooBar` and execute the command:
```shell
cd /Users/cmoullia/code/cncf/konveyor/openrewrite/foobar-example
mvn -U org.openrewrite.maven:rewrite-maven-plugin:run \
        -Drewrite.recipeArtifactCoordinates=dev.snowdrop:openrewrite-rules:1.0-SNAPSHOT \
        -Drewrite.activeRecipes=org.openrewrite.java.SayHelloRecipe \
        -Drewrite.options=fullyQualifiedClassName=dev.snowdrop.demo.FooBar
```
When done, check if openrewrite added a Hello method
```java
  package dev.snowdrop.demo;
  class FooBar {
      public String hello() {
          return "Hello from dev.snowdrop.demo.FooBar!";
      }
  }
```

## Issue

To debug: https://docs.openrewrite.org/reference/faq#my-recipe-runs-but-is-not-making-any-changes-whats-happening
```shell
mvnDebug -U org.openrewrite.maven:rewrite-maven-plugin:run \
  -Drewrite.recipeArtifactCoordinates=dev.snowdrop:openrewrite-rules:1.0-SNAPSHOT \
  -Drewrite.activeRecipes=org.openrewrite.FindParseFailures,org.openrewrite.java.search.FindMissingTypes,org.openrewrite.java.SayHelloRecipe \
  -Drewrite.exportDatatables=true
```