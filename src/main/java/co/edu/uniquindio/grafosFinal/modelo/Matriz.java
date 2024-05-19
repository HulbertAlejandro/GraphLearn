package co.edu.uniquindio.grafosFinal.modelo;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.util.List;

public class Matriz {

    public static String obtenerMatrizRelacion(Grafo grafo) {
        // Generar la matriz de relación del grafo
        int[][] matrizRelacion = generarMatrizRelacion(grafo);
        List<Nodo> nodos = grafo.getNodos();

        // Construir la representación de la matriz como una cadena de texto
        StringBuilder cadenaMatriz = new StringBuilder();

        // Agregar la primera fila con los nombres de los nodos
        cadenaMatriz.append("\t");
        for (Nodo nodo : nodos) {
            cadenaMatriz.append(nodo.getNombre()).append("\t");
        }
        cadenaMatriz.append("\n");

        // Agregar las filas con los nombres de los nodos y los valores de la matriz
        for (int i = 0; i < matrizRelacion.length; i++) {
            // Agregar el nombre del nodo al inicio de la fila
            cadenaMatriz.append(nodos.get(i).getNombre()).append("\t");
            for (int j = 0; j < matrizRelacion[i].length; j++) {
                cadenaMatriz.append(matrizRelacion[i][j]).append("\t");
            }
            cadenaMatriz.append("\n");
        }

        // Devolver la cadena de texto que representa la matriz
        return cadenaMatriz.toString();
    }

    private static int[][] generarMatrizRelacion(Grafo grafo) {
        List<Nodo> nodos = grafo.getNodos();
        int n = nodos.size();
        int[][] matriz = new int[n][n];

        // Inicializar la matriz con ceros
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = 0;
            }
        }

        // Llenar la matriz según las aristas del grafo
        for (Arista arista : grafo.getAristas()) {
            Nodo nodoInicio = arista.getNodoInicio();
            Nodo nodoFin = arista.getNodoFin();
            int indiceInicio = nodos.indexOf(nodoInicio);
            int indiceFin = nodos.indexOf(nodoFin);
            matriz[indiceInicio][indiceFin] = 1;
            matriz[indiceFin][indiceInicio] = 1; // La matriz de relación es simétrica
        }

        return matriz;
    }
}
