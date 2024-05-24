package co.edu.uniquindio.grafosFinal.modelo;

// La clase Nodo representa un nodo en un grafo, con propiedades para su nombre y coordenadas,
// y métodos para interactuar con otros nodos y con el grafo en el que está contenido.
public class Nodo {
    private String nombre;
    private double x;
    private double y;

    /**
     * Constructor de la clase Nodo.
     *
     * @param nombre El nombre del nodo.
     * @param x      La coordenada x del nodo.
     * @param y      La coordenada y del nodo.
     */
    public Nodo(String nombre, double x, double y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
    }

    /**
     * Obtiene el nombre del nodo.
     *
     * @return El nombre del nodo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la coordenada x del nodo.
     *
     * @return La coordenada x del nodo.
     */
    public double getX() {
        return x;
    }

    /**
     * Obtiene la coordenada y del nodo.
     *
     * @return La coordenada y del nodo.
     */
    public double getY() {
        return y;
    }

    /**
     * Verifica si hay una arista entre este nodo y otro nodo en el grafo dado.
     *
     * @param otroNodo El otro nodo con el que se desea verificar la conexión.
     * @param grafo    El grafo en el que se busca la conexión.
     * @return true si hay una arista entre este nodo y otroNodo, false en caso contrario.
     */
    public boolean tieneAristaCon(Nodo otroNodo, Grafo grafo) {
        // Verificar si hay una arista entre este nodo y otro nodo
        for (Arista arista : grafo.getAristas()) {
            if (arista.conectaCon(this, otroNodo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calcula el grado del nodo en el grafo dado.
     *
     * @param grafo El grafo en el que se desea calcular el grado del nodo.
     * @return El grado del nodo en el grafo.
     */
    public int getGrado(Grafo grafo) {
        // Calcular el grado del nodo
        int grado = 0;
        for (Arista arista : grafo.getAristas()) {
            if (arista.getNodoInicio() == this || arista.getNodoFin() == this) {
                grado++;
            }
        }
        return grado;
    }

    /**
     * Verifica si este nodo es adyacente al nodo dado en el grafo.
     *
     * @param otroNodo El otro nodo con el que se desea verificar la adyacencia.
     * @param grafo    El grafo en el que se busca la adyacencia.
     * @return true si este nodo es adyacente al otroNodo, false en caso contrario.
     */
    public boolean esAdyacente(Nodo otroNodo, Grafo grafo) {
        // Verificar si este nodo es adyacente al nodo dado
        return this.tieneAristaCon(otroNodo, grafo);
    }
}
