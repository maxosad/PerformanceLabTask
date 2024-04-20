package org.example.task2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Task2 {

    public final double EPS = 1e-39;
    public double distanceBetweenDots(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static void main(String[] args)  {


        Path circleFilePath = Paths.get(args[0]);
        Path dotFilePath = Paths.get( args[1]);
        System.out.println(circleFilePath.toString());
        System.out.println(dotFilePath.toString());
        Task2 task2 = new Task2();

        try {
            Scanner circleScanner = new Scanner(circleFilePath);
            Scanner dotScanner = new Scanner(dotFilePath);

            double centerX = circleScanner.nextDouble();
            double centerY = circleScanner.nextDouble();
            double radius = circleScanner.nextDouble();
            double distance;
            while(dotScanner.hasNext()) {
                double x = dotScanner.nextDouble();
                double y = dotScanner.nextDouble();

                distance = task2.distanceBetweenDots(x, y, centerX, centerY);

                if (distance < radius - task2.EPS) {
                    System.out.println(1);
                } else if (distance > radius + task2.EPS) {
                    System.out.println(2);
                } else {
                    System.out.println(0);
                }

            }

        } catch (IOException e) {

        }


    }
}
