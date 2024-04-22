package org.example.task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task4Test {

    private static Stream<Arguments> provideNumbersToCountMoves() {

        return Stream.of(
                Arguments.of(
                        16,
                        new ArrayList<>(List.of(1, 2, 10, 9))
                ),
                Arguments.of(
                        2,
                        new ArrayList<>(List.of(1, 2, 3))
                ),
                Arguments.of(
                        3,
                        new ArrayList<>(List.of(0, 0, 1, 2))
                ),
                Arguments.of(
                        1,
                        new ArrayList<>(List.of(0, 0, 0, 1))
                )
        );
    }

    @ParameterizedTest
    @DisplayName("tests should count moves")
    @MethodSource("provideNumbersToCountMoves")
    void countMovesTests(int expected, ArrayList<Integer> numList) {
        Task4 task4 = new Task4();

        var result = task4.countMoves(numList);

        assertEquals(expected, result);
    }
}