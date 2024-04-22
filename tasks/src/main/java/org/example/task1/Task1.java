package org.example.task1;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Task1 {
    public String countPath(int n, int m) {
        if (n <= 0) {
            throw new RuntimeException("n argument should be more than zero");
        }
        if (m <= 0) {
            throw new RuntimeException("m argument should be more than zero");
        }

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
        if (args.length != 2) {
            System.out.println("program should have 2 arguments");
            return;
        }
        int n = Integer.parseInt(args[0]);
        if (n <= 0) {
            System.out.println("n argument should be more than zero");
            return;
        }
        int m = Integer.parseInt(args[1]);
        if (m <= 0) {
            System.out.println("m argument should be more than zero");
            return;
        }
        Task1 task1 = new Task1();

        System.out.println(task1.countPath(n, m));
    }
}
