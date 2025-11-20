import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MatrizInversa {
    // iniciamos con la construcción de un main
    public static void main(String[] args) {
    String archivoEntrada = "matriz.txt";
        String archivoSalida = "matriz_inversa.txt";

        double[][] matriz = leerMatriz(archivoEntrada);

        if (matriz != null) {
            System.out.println("matriz original:");
            imprimirMatriz(matriz);

            double[][] inversa = calcularInversa(matriz);

            if (inversa != null) {
                System.out.println("\n matriz inversa:");
                imprimirMatriz(inversa);

                escribirArchivo(inversa, archivoSalida);
                System.out.println("\n archivo generado exitosamente: " + archivoSalida);
            } else {
                System.out.println("\n no se puede calcular la inversa (matriz no cuadrada o determinante = 0).");
            }
        } else {
            System.out.println("error al leer la matriz.");
        }
    }

    // lee la matriz desde el archivo
    public static double[][] leerMatriz(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int filas = 0;

            // Contar cuántas filas hay
            while ((linea = br.readLine()) != null) {
                filas++;
            }

            double[][] matriz = new double[filas][];
            br.close();

            // aqui lee nuevamente para llenar la matriz
            BufferedReader br2 = new BufferedReader(new FileReader(nombreArchivo));
            int i = 0;
            while ((linea = br2.readLine()) != null) {
                String[] valores = linea.trim().split(" ");
                matriz[i] = new double[valores.length];
                for (int j = 0; j < valores.length; j++) {
                    matriz[i][j] = Double.parseDouble(valores[j]);
                }
                i++;
            }
            br2.close();

            return matriz;

        } catch (IOException | NumberFormatException e) {
            System.out.println("error al leer archivo: " + e.getMessage());
            return null;
        }
    }

    // aqui se calcula la matriz inversa (solo para matrices 2x2 use en este ejemplo)
    public static double[][] calcularInversa(double[][] matriz) {
        int n = matriz.length;

        // se verifica si es cuadrada
        if (n != matriz[0].length) {
            return null;
        }

        if (n == 2) { // solo una prueba de 2x2
            double det = (matriz[0][0] * matriz[1][1]) - (matriz[0][1] * matriz[1][0]);

            if (det == 0) return null;

            double[][] inversa = {
                { matriz[1][1] / det, -matriz[0][1] / det },
                { -matriz[1][0] / det, matriz[0][0] / det }
            };

            return inversa;
        }

        System.out.println("Solo use una matriz de 2x2.");
        return null;
    }

}

