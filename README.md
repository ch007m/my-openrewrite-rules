## Instructions

To use it, build the project:
```shell
mvn clean install
```

Select a project where the old package name is `dev.snowdrop.demo` to rename it and execute the command:
```shell
mvn -U org.openrewrite.maven:rewrite-maven-plugin:run \
  -Drewrite.recipeArtifactCoordinates=dev.snowdrop:openrewrite-rules:1.0-SNAPSHOT \
  -Drewrite.activeRecipes=dev.snowdrop.SayHelloRecipe
```

## Issue

TODO