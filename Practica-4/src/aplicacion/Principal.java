package aplicacion;
import palabras.*;

public class Principal {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Debe proporcionar dos palabras como argumentos.");
            return;
        }
        
        String palabra1 = args[0];
        String palabra2 = args[1];
        
        int distancia = CalculadoraDistancias.calcularDistancia(palabra1, palabra2);
        
        System.out.println("La distancia entre las palabras \"" + palabra1 + "\" y \"" + palabra2 + "\" es " + distancia);
    }
}
