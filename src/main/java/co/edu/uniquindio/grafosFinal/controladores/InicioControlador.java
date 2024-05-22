package co.edu.uniquindio.grafosFinal.controladores;

import co.edu.uniquindio.grafosFinal.modelo.Arista;
import co.edu.uniquindio.grafosFinal.modelo.Grafo;
import co.edu.uniquindio.grafosFinal.modelo.GrafosFinal;
import co.edu.uniquindio.grafosFinal.modelo.Nodo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class InicioControlador implements Initializable{
    private final GrafosFinal grafosFinal = GrafosFinal.getInstance();
    private Grafo grafo;

    @FXML
    private Pane panelGrafo;

    @FXML
    private Button btnCrearArista;

    @FXML
    private Button btnEliminarNodo;

    @FXML
    private Button btnEliminarArista;

    private HashMap<Arista, Double> mapaAngulo;

    @FXML
    private void grafoConexo() {
        if (grafo == null) {
            // Mostrar un mensaje de error o realizar alguna acción apropiada
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("El grafo no ha sido inicializado.");
            alerta.showAndWait();
            return;
        }

        try {
            // Cargar el FXML del Grafo Conexo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ventanas/grafoConexo.fxml"));
            Parent root = loader.load();

            // Obtener el controlador del Grafo Conexo
            GrafoConexoController controller = loader.getController();

            // Enviar el grafo al controlador del Grafo Conexo
            controller.recibirGrafo(grafo);

            // Crear y mostrar la nueva ventana
            Stage stage = new Stage();
            stage.setTitle("Grafo Conexo");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void identificarTipo() {
        if (grafo == null) {
            // Mostrar un mensaje de error o realizar alguna acción apropiada
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("El grafo no ha sido inicializado.");
            alerta.showAndWait();
            return;
        }

        try {
            // Cargar el FXML del Grafo Conexo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ventanas/identificarTipo.fxml"));
            Parent root = loader.load();

            // Obtener el controlador del Grafo Conexo
            TipoGrafoController controller = loader.getController();

            // Enviar el grafo al controlador del Grafo Conexo
            controller.recibirGrafo(grafo);

            // Crear y mostrar la nueva ventana
            Stage stage = new Stage();
            stage.setTitle("Identificar Tipo");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mostrarCircuitoEuleriano() {
        if (grafo == null) {
            // Mostrar un mensaje de error o realizar alguna acción apropiada
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("El grafo no ha sido inicializado.");
            alerta.showAndWait();
            return;
        }

        try {
            // Cargar el FXML del Circuito Euleriano
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ventanas/circuitoEuleriano.fxml"));
            Parent root = loader.load();

            // Obtener el controlador del Circuito Euleriano
            CircuitoEulerianoController controller = loader.getController();

            // Enviar el grafo al controlador del Circuito Euleriano
            controller.recibirGrafo(grafo);

            // Crear y mostrar la nueva ventana
            Stage stage = new Stage();
            stage.setTitle("Circuito Euleriano");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mostrarCircuitoHamiltoniano() {
        if (grafo == null) {
            // Mostrar un mensaje de error o realizar alguna acción apropiada
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("El grafo no ha sido inicializado.");
            alerta.showAndWait();
            return;
        }

        try {
            // Cargar el FXML del Circuito Hamiltoniano
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ventanas/circuitoHamiltoniano.fxml"));
            Parent root = loader.load();

            // Obtener el controlador del Circuito Hamiltoniano
            CircuitoHamiltonianoController controller = loader.getController();

            // Enviar el grafo al controlador del Circuito Hamiltoniano
            controller.recibirGrafo(grafo);

            // Crear y mostrar la nueva ventana
            Stage stage = new Stage();
            stage.setTitle("Circuito Hamiltoniano");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void identificarGrafoHamiltoniano() {
        if (grafo == null) {
            // Mostrar un mensaje de error o realizar alguna acción apropiada
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("El grafo no ha sido inicializado.");
            alerta.showAndWait();
            return;
        }

        try {
            // Cargar el FXML del Grafo Hamiltoniano
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ventanas/grafoHamiltoniano.fxml"));
            Parent root = loader.load();

            // Obtener el controlador del Grafo Hamiltoniano
            GrafoHamiltonianoController controller = loader.getController();

            // Enviar el grafo al controlador del Grafo Hamiltoniano
            controller.recibirGrafo(grafo);

            // Crear y mostrar la nueva ventana
            Stage stage = new Stage();
            stage.setTitle("Grafo Hamiltoniano");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mostrarMatrizAdyacencia() {
        if (grafo == null) {
            // Mostrar un mensaje de error o realizar alguna acción apropiada
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("El grafo no ha sido inicializado.");
            alerta.showAndWait();
            return;
        }

        try {
            // Cargar el FXML del Grafo Conexo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ventanas/matrizAdyacencia.fxml"));
            Parent root = loader.load();

            // Obtener el controlador del Grafo Conexo
            MatrizAdyacenciaController controller = loader.getController();

            // Enviar el grafo al controlador del Grafo Conexo
            controller.recibirGrafo(grafo);

            // Crear y mostrar la nueva ventana
            Stage stage = new Stage();
            stage.setTitle("Matriz Adyacencia");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirDialogoAgregarNodo(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        TextInputDialog dialogo = new TextInputDialog();
        dialogo.setTitle("Agregar Nodo");
        dialogo.setHeaderText(null);
        dialogo.setContentText("Ingrese el nombre del nodo:");

        Optional<String> resultado = dialogo.showAndWait();
        resultado.ifPresent(nombre -> {
            boolean nombreRepetido = grafo.getNodos().stream()
                    .anyMatch(nodo -> nodo.getNombre().equals(nombre));
            if (nombreRepetido) {
                mostrarAlerta("Error", "Ya existe un nodo con este nombre.");
                return;
            }

            // Crear el nodo y agregarlo al grafo
            Nodo nuevoNodo = new Nodo(nombre, x, y);
            grafo.agregarNodo(nuevoNodo);
            dibujarNodo(nuevoNodo);
        });
    }

    public void mostrarMatrizRelacion(ActionEvent event) {
        // Verificar si el grafo se ha inicializado correctamente
        if (grafo == null) {
            // Mostrar un mensaje de error o realizar alguna acción apropiada
            mostrarAlerta("Error", "El grafo no ha sido inicializado.");
            return;
        }

        // Obtener la escena actual
        Scene scene = ((Node) event.getSource()).getScene();

        // Crear un cargador de FXMLLoader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ventanas/matrizRelacion.fxml"));
        Parent root;

        try {
            // Cargar la nueva ventana
            root = loader.load();

            // Obtener el controlador de la nueva ventana
            MatrizRelacionController controller = loader.getController();

            // Enviar el grafo al controlador de la nueva ventana
            controller.recibirGrafo(grafo);

            // Mostrar la nueva ventana sin cerrar la anterior
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void abrirDialogoCrearArista() {
        // Crear un diálogo para ingresar los nombres de los nodos
        TextInputDialog dialogo = new TextInputDialog();
        dialogo.setTitle("Crear Arista");
        dialogo.setHeaderText(null);
        dialogo.setContentText("Ingrese los nombres de los nodos (separados por coma):");

        Optional<String> resultado = dialogo.showAndWait();
        resultado.ifPresent(input -> {
            String[] nodos = input.split(",");
            if (nodos.length != 2) {
                mostrarAlerta("Error", "Debe ingresar exactamente dos nombres de nodos separados por coma.");
                return;
            }

            // Buscar los nodos en el grafo por sus nombres
            Nodo nodoInicio = grafo.getNodos().stream()
                    .filter(nodo -> nodo.getNombre().equals(nodos[0]))
                    .findFirst()
                    .orElse(null);
            Nodo nodoFin = grafo.getNodos().stream()
                    .filter(nodo -> nodo.getNombre().equals(nodos[1]))
                    .findFirst()
                    .orElse(null);

            if (nodoInicio == null || nodoFin == null) {
                mostrarAlerta("Error", "Uno o ambos nodos no existen.");
                return;
            }

            // Crear la arista y agregarla al grafo
            Arista arista = new Arista(nodoInicio, nodoFin);
            grafo.agregarArista(arista);

            // Calcular ángulo único para la arista
            double angulo = calcularAnguloUnico(arista);
            mapaAngulo.put(arista, angulo);

            // Dibujar la arista en el panel
            dibujarArista(arista, angulo);
        });
    }

    private double calcularAnguloUnico(Arista nuevaArista) {
        // Obtener las aristas ya existentes
        ArrayList<Arista> aristasExistentes = new ArrayList<>(grafo.getAristas());
        aristasExistentes.remove(nuevaArista); // Remover la nueva arista para evitar comparaciones innecesarias

        // Calcular ángulo único para la nueva arista
        double angulo = 0;
        while (true) {
            boolean anguloUnico = true;
            for (Arista arista : aristasExistentes) {
                double anguloExistente = mapaAngulo.get(arista);
                if (Math.abs(anguloExistente - angulo) < Math.PI / 6) {
                    anguloUnico = false;
                    break;
                }
            }
            if (anguloUnico) {
                break;
            }
            angulo += Math.PI / 6;
        }
        return angulo;
    }

    @FXML
    private void abrirDialogoEliminarNodo() {
        // Crear un diálogo para ingresar el nombre del nodo a eliminar
        TextInputDialog dialogo = new TextInputDialog();
        dialogo.setTitle("Eliminar Nodo");
        dialogo.setHeaderText(null);
        dialogo.setContentText("Ingrese el nombre del nodo a eliminar:");

        Optional<String> resultado = dialogo.showAndWait();
        resultado.ifPresent(nombre -> {
            // Buscar el nodo en el grafo por su nombre
            Nodo nodoAEliminar = grafo.getNodos().stream()
                    .filter(nodo -> nodo.getNombre().equals(nombre))
                    .findFirst()
                    .orElse(null);

            if (nodoAEliminar == null) {
                mostrarAlerta("Error", "El nodo no existe.");
                return;
            }

            // Eliminar el nodo y sus aristas asociadas
            grafo.getAristas().removeIf(arista ->
                    arista.getNodoInicio() == nodoAEliminar || arista.getNodoFin() == nodoAEliminar);
            grafo.getNodos().remove(nodoAEliminar);

            // Actualizar el panel de dibujo
            actualizarPanelDibujo();
        });
    }

    @FXML
    private void abrirDialogoEliminarArista() {
        // Crear un diálogo para ingresar los nombres de los nodos que están conectados por la arista a eliminar
        TextInputDialog dialogo = new TextInputDialog();
        dialogo.setTitle("Eliminar Arista");
        dialogo.setHeaderText(null);
        dialogo.setContentText("Ingrese los nombres de los nodos conectados por la arista (separados por coma):");

        Optional<String> resultado = dialogo.showAndWait();
        resultado.ifPresent(input -> {
            String[] nodos = input.split(",");
            if (nodos.length != 2) {
                mostrarAlerta("Error", "Debe ingresar exactamente dos nombres de nodos separados por coma.");
                return;
            }

            // Buscar los nodos en el grafo por sus nombres
            Nodo nodoInicio = grafo.getNodos().stream()
                    .filter(nodo -> nodo.getNombre().equals(nodos[0]))
                    .findFirst()
                    .orElse(null);
            Nodo nodoFin = grafo.getNodos().stream()
                    .filter(nodo -> nodo.getNombre().equals(nodos[1]))
                    .findFirst()
                    .orElse(null);

            if (nodoInicio == null || nodoFin == null) {
                mostrarAlerta("Error", "Uno o ambos nodos no existen.");
                return;
            }

            // Buscar la arista que conecta los nodos
            ArrayList<Arista> aristasAEliminar = new ArrayList<>();
            grafo.getAristas().forEach(arista -> {
                if ((arista.getNodoInicio() == nodoInicio && arista.getNodoFin() == nodoFin) ||
                        (arista.getNodoInicio() == nodoFin && arista.getNodoFin() == nodoInicio)) {
                    aristasAEliminar.add(arista);
                }
            });

            if (aristasAEliminar.isEmpty()) {
                mostrarAlerta("Error", "No existe una arista entre los nodos especificados.");
                return;
            }

            // Eliminar la arista del grafo y actualizar el panel de dibujo
            grafo.getAristas().removeAll(aristasAEliminar);
            actualizarPanelDibujo();
        });
    }


    private void dibujarNodo(Nodo nodo) {
        Circle circulo = new Circle(nodo.getX(), nodo.getY(), 20, Color.WHITE); // Nodo blanco
        Label etiqueta = new Label(nodo.getNombre());
        etiqueta.setTextFill(Color.BLACK); // Texto blanco
        etiqueta.setStyle("-fx-font-weight: bold;"); // Poner el texto en negrita
        panelGrafo.getChildren().addAll(circulo, etiqueta);

        // Centrar el label en el círculo
        double anchoEtiqueta = etiqueta.getText().length() * 7; // Ajustar según el tamaño de la fuente
        double altoEtiqueta = 10; // Ajustar según el tamaño de la fuente

        etiqueta.setLayoutX(nodo.getX() - anchoEtiqueta / 2 - 2); // Ajuste de posición del texto
        etiqueta.setLayoutY(nodo.getY() - altoEtiqueta / 2 - 2); // Ajuste de posición del texto
    }

    private void dibujarArista(Arista arista, double angulo) {
        // Obtener las coordenadas del nodo
        double inicioX = arista.getNodoInicio().getX();
        double inicioY = arista.getNodoInicio().getY();
        double finX = arista.getNodoFin().getX();
        double finY = arista.getNodoFin().getY();

        double radio = 20; // Radio del círculo

        if (inicioX == finX && inicioY == finY) {
            // Dibujar un bucle (arista de A a A)
            Circle circulo = new Circle(inicioX, inicioY - radio, radio);
            circulo.setStroke(Color.WHITE); // Color blanco para el bucle
            circulo.setFill(Color.TRANSPARENT);
            panelGrafo.getChildren().add(circulo);
        } else {
            // Calcular los puntos de control para la curva
            double controlX1 = inicioX + Math.cos(angulo) * 100;
            double controlY1 = inicioY + Math.sin(angulo) * 100;

            // Crear la arista curva entre los nodos de inicio y fin
            QuadCurve curva = new QuadCurve(inicioX, inicioY, controlX1, controlY1, finX, finY);
            curva.setStroke(Color.WHITE); // Color blanco para la arista curva
            curva.setFill(null); // Rellenar la arista con color transparente

            // Agregar la arista al panel de dibujo
            panelGrafo.getChildren().add(curva);
        }
    }

    private void actualizarPanelDibujo() {
        // Limpiar el panel de dibujo
        panelGrafo.getChildren().clear();

        // Ordenar las aristas por ángulo
        ArrayList<Arista> aristasOrdenadas = new ArrayList<>(grafo.getAristas());
        aristasOrdenadas.sort((arista1, arista2) -> {
            double angulo1 = mapaAngulo.get(arista1);
            double angulo2 = mapaAngulo.get(arista2);
            return Double.compare(angulo1, angulo2);
        });

        // Volver a dibujar todas las aristas
        aristasOrdenadas.forEach(arista -> {
            double angulo = mapaAngulo.get(arista);
            dibujarArista(arista, angulo);
        });

        // Volver a dibujar todos los nodos
        grafo.getNodos().forEach(this::dibujarNodo);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        grafo = new Grafo();
        mapaAngulo = new HashMap<>();
    }

    public void info(ActionEvent actionEvent) {
        grafosFinal.loadStage("/ventanas/infoAplicacion.fxml", actionEvent);
    }
}
