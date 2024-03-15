package main;

import dominio.mates;

public class main {
    public static void main(String[] args) {
        int numSamples = 1000000;
        double approximation = mates.approximatePi(numSamples);
        System.out.println("Aproximación de pi: " + approximation);
    }
}
