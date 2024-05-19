package co.edu.uniquindio.grafosFinal.controladores;

import co.edu.uniquindio.grafosFinal.modelo.Grafo;
import co.edu.uniquindio.grafosFinal.modelo.Matriz;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MatrizRelacionController implements Initializable {

    @FXML
    private Label titulo;

    @FXML
    private Label texto, texto1;

    private Grafo grafo;

    // No utilices el grafo en el método initialize directamente
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titulo.setText("Matriz de Relación");
        texto.setText(
                "Una matriz de relación es una herramienta fundamental en diversos campos como la matemática, la informática, las ciencias sociales y más. \n\n" +
                        "En matemáticas, una matriz de relación es una matriz cuadrada que describe las relaciones entre elementos de un conjunto. Cada entrada en la matriz indica si un par de elementos están relacionados de alguna manera. Por ejemplo, si los elementos representan nodos de un grafo, una entrada distinta de cero indica que hay una arista entre los nodos correspondientes.\n\n" +
                        "En informática, las matrices de relación se utilizan en algoritmos de búsqueda, recorrido de grafos y en la representación de bases de datos relacionales.\n\n" +
                        "En ciencias sociales, las matrices de relación pueden utilizarse para modelar interacciones entre individuos, grupos o entidades en una red social o en un sistema de análisis de preferencias."
        );
    }

    public void recibirGrafo(Grafo grafo) {
        this.grafo = grafo;
        // Ahora que el grafo ha sido asignado, llama a un método para procesarlo
        inicializarMatrizRelacion();
    }

    private void inicializarMatrizRelacion() {
        if (grafo != null) {
            // Procesar el grafo para obtener la matriz de relación
            String matrizRelacion = Matriz.obtenerMatrizRelacion(grafo);
            // Actualizar el texto del label `texto1` con la matriz de relación
            texto1.setText(matrizRelacion);
        } else {
            // Manejar el caso donde el grafo sigue siendo null
            texto1.setText("El grafo no ha sido inicializado.");
        }
    }
}
