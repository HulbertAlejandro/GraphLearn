package co.edu.uniquindio.grafosFinal.controladores;

import co.edu.uniquindio.grafosFinal.modelo.Grafo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CircuitoEulerianoController implements Initializable {

    @FXML
    private Label titulo;

    @FXML
    private Label texto, texto1;

    private Grafo grafo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titulo.setText("Circuito Euleriano");
        texto.setText(
                "Un circuito euleriano es un concepto fundamental en teoría de grafos con aplicaciones en diversos campos como matemáticas, informática y logística. \n\n" +
                        "En matemáticas, un circuito euleriano es un camino que recorre cada arista de un grafo exactamente una vez y regresa al nodo inicial. Esto implica que cada vértice del grafo es de grado par, ya que cada vez que se ingresa a un nodo, se sale de él. \n\n" +
                        "En informática, los circuitos eulerianos son utilizados en algoritmos de búsqueda y recorrido de grafos. Son especialmente útiles en la planificación de rutas óptimas en redes de transporte o en la optimización de rutas de entrega en logística. \n\n" +
                        "En aplicaciones prácticas, los circuitos eulerianos pueden ayudar a encontrar soluciones eficientes a problemas de optimización de recursos y planificación de rutas en una amplia gama de campos, desde el diseño de redes de comunicación hasta la logística en la distribución de bienes."
        );
    }

    public void recibirGrafo(Grafo grafo) {
        this.grafo = grafo;
        if (grafo != null) {
            // Procesar el grafo para obtener el circuito euleriano
            String circuitoEuleriano = grafo.getCircuitoEuleriano();
            // Actualizar el texto del label `texto1` con el circuito euleriano
            texto1.setText(circuitoEuleriano);
        } else {
            // Manejar el caso donde el grafo sigue siendo null
            texto1.setText("El grafo no ha sido inicializado.");
        }
    }
}
