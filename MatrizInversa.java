public class MatrizInversa {
    // iniciamos con la construcción de un main
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
