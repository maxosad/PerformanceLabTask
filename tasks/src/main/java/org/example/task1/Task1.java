package org.example.task1;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Task1 {
    public String countPath(int n, int m) {
        int step = m - 1;
        ArrayList<Integer> path = new ArrayList<>(n);

        int currentElement = 1;
        int newPosition;
        do {
            path.add(currentElement);
            newPosition = currentElement + step;

            currentElement = newPosition % n;
            if (currentElement == 0) {
                currentElement = n;
            }
        } while (currentElement != 1);

        return path.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n <= 0) {
            throw new RuntimeException("n argument should be more than zero");
        }
        int m = Integer.parseInt(args[1]);
        if (m <= 0) {
            throw new RuntimeException("m argument should be more than zero");
        }
        Task1 task1 = new Task1();

        System.out.println(task1.countPath(n, m));
    }
}
