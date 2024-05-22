package co.edu.uniquindio.grafosFinal.controladores;

import co.edu.uniquindio.grafosFinal.modelo.GrafosFinal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PresentacionControlador {
    private final GrafosFinal grafosFinal = GrafosFinal.getInstance();

    @FXML
    void atras(ActionEvent event) {
        grafosFinal.loadStage("/ventanas/inicio.fxml",event);
    }

}
