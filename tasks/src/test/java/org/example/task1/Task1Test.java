package org.example.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task1Test {


    private static Stream<Arguments> provideNAndMToCountPath() {

        return Stream.of(
                Arguments.of(
                        "13",
                        4,
                        3
                ),
                Arguments.of(
                        "14253",
                        5,
                        4
                ),
                Arguments.of(
                        "1",
                        5,
                        1
                )
                ,
                Arguments.of(
                        "1",
                        100,
                        1
                ),
                Arguments.of(
                        "1",
                        1,
                        1
                ),
                Arguments.of(
                        "1",
                        1,
                        5
                ),
                Arguments.of(
                        "1",
                        3,
                        10
                ),
                Arguments.of(
                        "13579",
                        10,
                        3
                )
        );
    }

    @ParameterizedTest
    @DisplayName("tests should finish successfully")
    @MethodSource("provideNAndMToCountPath")
    void countPathTests(String expected, int n, int m) {
        Task1 task1 = new Task1();

        var result = task1.countPath(n, m);

        assertEquals(expected, result);
    }


    private static Stream<Arguments> provideNAndMToThrow() {

        return Stream.of(
                Arguments.of(
                        "n argument should be more than zero",
                        0,
                        3
                ),
                Arguments.of(
                        "n argument should be more than zero",
                        -1,
                        4
                ),
                Arguments.of(
                        "n argument should be more than zero",
                        -100,
                        1
                )
                ,
                Arguments.of(
                        "m argument should be more than zero",
                        100,
                        0
                ),
                Arguments.of(
                        "m argument should be more than zero",
                        100,
                        -1
                ),
                Arguments.of(
                        "m argument should be more than zero",
                        1,
                        -105
                )
        );
    }

    @ParameterizedTest
    @DisplayName("tests should throw Runtime exception")
    @MethodSource("provideNAndMToThrow")
    void throwTests(String expectedThrowMessage, int n, int m) {
        Task1 task1 = new Task1();

        Exception exception = assertThrows(RuntimeException.class, () -> {
            task1.countPath(n, m);
        });
        String result = exception.getMessage();

        assertEquals(expectedThrowMessage, result);
    }
}