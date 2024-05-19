package co.edu.uniquindio.grafosFinal.controladores;

import co.edu.uniquindio.grafosFinal.modelo.Grafo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class GrafoConexoController implements Initializable {

    @FXML
    private Label titulo;

    @FXML
    private Label texto, texto1;

    private Grafo grafo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titulo.setText("Grafo Conexo");
        texto.setText(
                "Un grafo conexo es un tipo de grafo en el cual existe al menos un camino entre cada par de nodos. En otras palabras, no hay nodos aislados y todos están conectados de alguna manera.\n\n" +
                        "En matemáticas y teoría de grafos, los grafos conexos son de gran importancia debido a su capacidad para modelar situaciones donde la conectividad es fundamental. Por ejemplo, en redes de comunicación, sistemas de transporte o circuitos eléctricos, la existencia de una conexión entre todos los nodos es esencial para el funcionamiento eficiente del sistema.\n\n" +
                        "En informática, los grafos conexos son utilizados en algoritmos de búsqueda, en la detección de componentes conectados en redes y en la planificación de rutas óptimas en aplicaciones logísticas y de transporte.\n\n" +
                        "En resumen, los grafos conexos son una herramienta poderosa para modelar y resolver problemas que involucran la conectividad entre entidades o nodos en un sistema."
        );
    }

    public void recibirGrafo(Grafo grafo) {
        this.grafo = grafo;
        if (grafo != null) {
            // Determinar si el grafo es conexo
            boolean estado = grafo.isGraphConnected();
            // Obtener la justificación de la conectividad
            String mensaje = grafo.getConexityJustification(estado);
            // Actualizar el texto del label `texto1` con el mensaje de conectividad
            texto1.setText(mensaje);
        } else {
            // Manejar el caso donde el grafo sigue siendo null
            texto1.setText("El grafo no ha sido inicializado.");
        }
    }
}
