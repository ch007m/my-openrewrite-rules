## Instructions

To use it, build the project:
```shell
mvn clean install
```

Select a project containing as fully qualified name `dev.snowdrop.demo.FooBar` 
```java
package dev.snowdrop.demo;

class FooBar {
}
```
and execute the command:
```shell
mvn -U org.openrewrite.maven:rewrite-maven-plugin:run \
        -Drewrite.recipeArtifactCoordinates=dev.snowdrop:openrewrite-rules:1.0-SNAPSHOT \
        -Drewrite.activeRecipes=org.openrewrite.java.SayHelloToFooBarRecipe
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
  -Drewrite.activeRecipes=org.openrewrite.FindParseFailures,org.openrewrite.java.search.FindMissingTypes,org.openrewrite.java.SayHelloToFooBarRecipe \
  -Drewrite.exportDatatables=true
```
