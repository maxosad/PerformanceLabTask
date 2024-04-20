package org.example.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
                )
        );
    }

    @ParameterizedTest
    @DisplayName("tests should finish successfully")
    @MethodSource("provideNAndMToCountPath")
    void countPath(String expected, int n, int m) {
        Task1 task1 = new Task1();

        var result = task1.countPath(n, m);

        assertEquals(expected, result);
    }
}