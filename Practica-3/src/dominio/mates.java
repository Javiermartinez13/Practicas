package dominio;

import java.util.Random;

/**
 * Clase que proporciona métodos para aproximar el número pi utilizando el método de Monte Carlo.
 */
public class mates {

    /**
     * Aproxima el valor de pi utilizando el método de Montecarlo.
     *
     * @param numSamples Número de muestras a generar.
     * @return Aproximación del valor de pi.
     */
    public static double approximatePi(int numSamples) {
        Random random = new Random();

        // Función lambda para determinar si un punto está dentro del círculo unitario
        MontecarloSimulation isInsideCircle = (x, y) -> x * x + y * y <= 1;

        // Genera las muestras y cuenta cuántas están dentro del círculo
        int insideCircleCount = generateSamples(numSamples, random, isInsideCircle);

        // Calcula la aproximación de pi
        return 4.0 * insideCircleCount / numSamples;
    }

    /**
     * Genera muestras aleatorias y cuenta cuántas de ellas están dentro del círculo unitario.
     *
     * @param numSamples Número de muestras a generar.
     * @param random     Generador de números aleatorios.
     * @param condition  Condición para determinar si un punto está dentro del círculo.
     * @return Cantidad de muestras dentro del círculo.
     */
    public static int generateSamples(int numSamples, Random random, MontecarloSimulation condition) {
        int count = 0;
        for (int i = 0; i < numSamples; i++) {
            double x = random.nextDouble(); // Genera coordenada x entre 0 y 1
            double y = random.nextDouble(); // Genera coordenada y entre 0 y 1
            if (condition.test(x, y)) { // Verifica si el punto está dentro del círculo
                count++;
            }
        }
        return count;
    }

    /**
     * Interfaz funcional para representar una condición en una simulación de Montecarlo.
     */
    @FunctionalInterface
    public interface MontecarloSimulation {
        boolean test(double x, double y);
    }
}
