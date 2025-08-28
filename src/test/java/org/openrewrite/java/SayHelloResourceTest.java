package org.openrewrite.java;

import org.junit.jupiter.api.Test;
import org.openrewrite.java.SayHelloRecipe;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;

import static org.openrewrite.java.Assertions.java;

class SayHelloResourceTest implements RewriteTest {

    @Override
    public void defaults(RecipeSpec spec) {
        spec.recipe(new SayHelloRecipe("dev.snowdrop.demo.FooBar"));
    }

    @Test
    void addsHelloToFooBar() {
        rewriteRun(
          java(
            """
            package dev.snowdrop.demo;

            class FooBar {
            }
            """,
            """
            package dev.snowdrop.demo;

            class FooBar {
                public String hello() {
                    return "Hello from dev.snowdrop.demo.FooBar!";
                }
            }
            """
          )
        );
    }

    @Test
    void doesNotChangeExistingHello() {
        rewriteRun(
          java(
    """
            package dev.snowdrop.demo;

            class FooBar {
                public String hello() { return ""; }
            }
            """
          )
        );
    }

    @Test
    void doesNotChangeOtherClasses() {
        rewriteRun(
          java(
    """
            package dev.snowdrop.demo;

            class Bash {
            }
            """
          )
        );
    }
}
