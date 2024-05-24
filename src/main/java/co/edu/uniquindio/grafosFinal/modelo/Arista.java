package co.edu.uniquindio.grafosFinal.modelo;

/**
 * La clase Arista representa una arista que conecta dos nodos en un grafo.
 */
public class Arista {
    // Nodo de inicio de la arista
    private Nodo nodoInicio;
    // Nodo de fin de la arista
    private Nodo nodoFin;

    /**
     * Constructor de la clase Arista.
     *
     * @param nodoInicio el nodo de inicio de la arista
     * @param nodoFin el nodo de fin de la arista
     */
    public Arista(Nodo nodoInicio, Nodo nodoFin) {
        this.nodoInicio = nodoInicio;
        this.nodoFin = nodoFin;
    }

    /**
     * Obtiene el nodo de inicio de la arista.
     *
     * @return el nodo de inicio de la arista
     */
    public Nodo getNodoInicio() {
        return nodoInicio;
    }

    /**
     * Obtiene el nodo de fin de la arista.
     *
     * @return el nodo de fin de la arista
     */
    public Nodo getNodoFin() {
        return nodoFin;
    }

    /**
     * Verifica si esta arista conecta los nodos dados.
     *
     * @param nodo el primer nodo
     * @param otroNodo el segundo nodo
     * @return true si la arista conecta los nodos dados, false en caso contrario
     */
    public boolean conectaCon(Nodo nodo, Nodo otroNodo) {
        // Verificar si esta arista conecta los nodos dados
        return (nodoInicio == nodo && nodoFin == otroNodo) || (nodoInicio == otroNodo && nodoFin == nodo);
    }
}
