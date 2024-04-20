package org.example.task2;

import org.example.task1.Task1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    private static Stream<Arguments> provideCoordinatesForCountDistance() {

        return Stream.of(
                Arguments.of(
                        Math.sqrt(2),
                        0, 0,
                        1, 1
                ),
                Arguments.of(
                        2,
                        0, 1,
                        0, -1
                )
        );
    }

    @ParameterizedTest
    @DisplayName("count distance tests should finish successfully")
    @MethodSource("provideCoordinatesForCountDistance")
    void countDistanceBetweenDots(double expected, double x1, double y1, double x2, double y2) {
        Task2 task2 = new Task2();

        var result = task2.distanceBetweenDots(x1, y1, x2, y2);

        assertEquals(expected, result);
    }


    @Test
    @DisplayName("generate 100 dots inside circle")
    void dotsInCircle() {
        Random random = new Random(0);
        Task2 task2 = new Task2();
        double radius = random.nextDouble(3, 1e38);
        double centerX = random.nextDouble(3, 1e38);
        double centerY = random.nextDouble(3, 1e38);
        double x, y;


        for (int i = 0; i < 100; i++) {
            x = centerX + random.nextDouble(1, Math.sqrt(radius) - 1);
            y = centerY + random.nextDouble(1, Math.sqrt(radius) - 1);

            var result = task2.positionCode(task2.distanceBetweenDots(centerX, centerY, x, y), radius);
            if (result == 2) {
                System.out.println(centerX);
                System.out.println(centerY);
                System.out.println(radius);
                System.out.println(x);
                System.out.println(y);

            }
            assertEquals(1, result);
        }
    }



}