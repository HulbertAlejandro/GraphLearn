package co.edu.uniquindio.grafosFinal.modelo;

public class Arista {
    // Nodo de inicio de la arista
    private Nodo nodoInicio;
    // Nodo de fin de la arista
    private Nodo nodoFin;

    public Arista(Nodo nodoInicio, Nodo nodoFin) {
        this.nodoInicio = nodoInicio;
        this.nodoFin = nodoFin;
    }

    public Nodo getNodoInicio() {
        return nodoInicio;
    }

    public Nodo getNodoFin() {
        return nodoFin;
    }

    //Verifica si esta arista conecta los nodos dados.
    //True si la arista conecta los nodos dados, false en caso contrario.
    public boolean conectaCon(Nodo nodo, Nodo otroNodo) {
        // Verificar si esta arista conecta los nodos dados
        return (nodoInicio == nodo && nodoFin == otroNodo) || (nodoInicio == otroNodo && nodoFin == nodo);
    }
}
