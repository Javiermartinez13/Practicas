package palabras;

public class CalculadoraDistancias {
    /**
     * Calcula la distancia de edición, tal y como la expone
     * Jurafsky entre las cadenas `s1` y `s2`.
     */
    public static int calcularDistancia(String s1, String s2) {
        int[][] distancia = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            distancia[i][0] = i;
        }

        for (int j = 0; j <= s2.length(); j++) {
            distancia[0][j] = j;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int cambio = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                // Aumenta en 2 si tanto i como j han cambiado
                int cambioTotal = (cambio == 1 && i != j) ? 2 : cambio;
                distancia[i][j] = Math.min(distancia[i - 1][j] + 1, Math.min(distancia[i][j - 1] + 1, distancia[i - 1][j - 1] + cambioTotal));
            }
        }

        return distancia[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String palabra1 = "kitten";
        String palabra2 = "sitting";
        int distancia = calcularDistancia(palabra1, palabra2);
        System.out.println("La distancia de edición entre \"" + palabra1 + "\" y \"" + palabra2 + "\" es: " + distancia);
    }
}
