package br.com.edu.ufca;

public class DistanceCalculator {

    /* Geometric distance between points: √(xB – xA)² + (yB – yA)² */
    public static double getDistance(double fromX, double fromY, double toX, double toY) {
        return Math.sqrt(Math.pow(toX - fromX, 2) + Math.pow(toY - fromY, 2));
    }
}
