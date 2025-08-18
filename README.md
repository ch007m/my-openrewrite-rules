## Instructions

To use it, build the project:
```shell
mvn clean install
```

Select a project where the old package name is `dev.snowdrop.demo` to rename it and execute the command:
```shell
mvn -U org.openrewrite.maven:rewrite-maven-plugin:run \
         -Drewrite.recipeArtifactCoordinates=dev.snowdrop:openrewrite-rules:1.0-SNAPSHOT \
         -Drewrite.activeRecipes=dev.snowdrop.demo.DemoToBookingPackage
```

## Issue

Openrewrite maven plugin cannot find the recipe
```shell
[ERROR] Failed to execute goal org.openrewrite.maven:rewrite-maven-plugin:6.16.0:run (default-cli) on project spring-boot-rest: Execution default-cli of goal org.openrewrite.maven:rewrite-maven-plugin:6.16.0:run failed: Recipe(s) not found: dev.snowdrop.demo.DemoToBookingPackage                                                                                                                                                                     
[ERROR] Did you mean: org.openrewrite.java.ChangePackage
[ERROR] -> [Help 1]
```