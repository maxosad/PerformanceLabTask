package org.example.task4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task4 {

    public int countMoves(ArrayList<Integer> numsList) {
        Collections.sort(numsList);

        int median = numsList.get(numsList.size() / 2);
        int moves = 0;

        for (int i = 0; i < numsList.size(); i++) {
            moves += Math.abs(median - numsList.get(i));
        }

        return moves;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("program should have one argument");
            return;
        }

        ArrayList<Integer> numsList = new ArrayList<>();

        try (BufferedReader bufferedFileReader = new BufferedReader(new FileReader(args[0]))) {
            String line = bufferedFileReader.readLine();
            while (line != null) {
                numsList.add(Integer.parseInt(line));
                line = bufferedFileReader.readLine();
            }
            Task4 task4 = new Task4();
            System.out.println(task4.countMoves(numsList));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
