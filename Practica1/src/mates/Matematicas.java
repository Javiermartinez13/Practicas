package mates;

import java.util.Random;

public class Matematicas {

    public static double generarNumeroPi(long pasos) {
        long puntosEnCirculo = 0;

        Random random = new Random();

        for (long i = 0; i < pasos; i++) {
            double x = random.nextDouble();  
            double y = random.nextDouble();  

            
            double distanciaAlCentro = Math.sqrt(Math.pow(x - 0.5, 2) + Math.pow(y - 0.5, 2));

            
            if (distanciaAlCentro <= 0.5) {
                puntosEnCirculo++;
            }
        }

        
        double aproximacionPi = 4.0 * puntosEnCirculo / pasos;

        return aproximacionPi;
    }

    public static void main(String[] args) {
        long pasos = 100000;  // Puedes ajustar este valor según sea necesario
        double aproximacionPi = generarNumeroPi(pasos);
        System.out.println("Aproximación de pi después de " + pasos + " pasos: " + aproximacionPi);
    }
}
