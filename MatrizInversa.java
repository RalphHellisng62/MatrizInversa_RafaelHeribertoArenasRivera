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
    

}

