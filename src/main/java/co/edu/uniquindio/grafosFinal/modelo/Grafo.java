package co.edu.uniquindio.grafosFinal.modelo;

import java.util.*;

// La clase Grafo representa un grafo no dirigido con nodos y aristas.
public class Grafo {
    private List<Nodo> nodos;
    private List<Arista> aristas;

    /**
     * Constructor de la clase Grafo.
     */
    public Grafo() {
        nodos = new ArrayList<>();
        aristas = new ArrayList<>();
    }

    /**
     * Agrega un nodo al grafo.
     *
     * @param nodo el nodo a agregar
     */
    public void agregarNodo(Nodo nodo) {
        nodos.add(nodo);
    }

    /**
     * Agrega una arista al grafo.
     *
     * @param arista la arista a agregar
     */
    public void agregarArista(Arista arista) {
        aristas.add(arista);
    }

    /**
     * Obtiene la lista de nodos del grafo.
     *
     * @return la lista de nodos
     */
    public List<Nodo> getNodos() {
        return nodos;
    }

    /**
     * Obtiene la lista de aristas del grafo.
     *
     * @return la lista de aristas
     */
    public List<Arista> getAristas() {
        return aristas;
    }

    /**
     * Comprueba si un grafo es conexo.
     *
     * <p>Un grafo se considera conexo si existe un camino entre cualquier par de nodos.</p>
     *
     * @return true si el grafo es conexo, false en caso contrario
     */
    public boolean isGraphConnected() {
        if (nodos.isEmpty()) {
            return false;
        }

        Set<Nodo> visitedNodes = new HashSet<>();
        dfs(nodos.get(0), visitedNodes);

        return visitedNodes.size() == nodos.size();
    }

    /**
     * Realiza una búsqueda en profundidad (DFS) a partir de un nodo dado.
     *
     * <p>Este método explora el grafo a partir del nodo dado y marca todos los nodos alcanzables desde
     * ese nodo como visitados.</p>
     *
     * @param nodo el nodo de inicio para la DFS
     * @param visitedNodes el conjunto de nodos visitados
     */
    private void dfs(Nodo nodo, Set<Nodo> visitedNodes) {
        visitedNodes.add(nodo);

        for (Arista arista : aristas) {
            Nodo nodoVecino = null;
            if (arista.getNodoInicio() == nodo) {
                nodoVecino = arista.getNodoFin();
            } else if (arista.getNodoFin() == nodo) {
                nodoVecino = arista.getNodoInicio();
            }

            if (nodoVecino != null && !visitedNodes.contains(nodoVecino)) {
                dfs(nodoVecino, visitedNodes);
            }
        }
    }

    /**
     * Proporciona una justificación sobre la conectividad del grafo.
     *
     * @param isConnected un valor booleano que indica si el grafo es conexo o no
     * @return una justificación textual sobre la conectividad del grafo
     */
    public String getConexityJustification(boolean isConnected) {
        if (isConnected) {
            return "El grafo es conexo porque hay un camino entre cada par de nodos.";
        } else {
            return "El grafo no es conexo porque hay al menos un par de nodos que no están conectados.";
        }
    }

    /**
     * Obtiene un circuito Euleriano del grafo si existe.
     *
     * <p>Un grafo tiene un circuito Euleriano si todos sus nodos tienen un grado par.</p>
     *
     * @return una cadena que describe el circuito Euleriano si existe, o un mensaje indicando que no existe
     */
    public String getCircuitoEuleriano() {
        if (!isEuleriano()) {
            return "El grafo no tiene circuito Euleriano porque no cumple con la condición de que todos sus nodos deben tener grado par.";
        } else {
            List<Nodo> circuito = new ArrayList<>();
            Deque<Nodo> stack = new ArrayDeque<>();
            Map<Nodo, List<Nodo>> adjacencyMap = buildAdjacencyMap();

            Nodo inicio = nodos.get(0);
            stack.push(inicio);

            while (!stack.isEmpty()) {
                Nodo actual = stack.peek();
                if (adjacencyMap.containsKey(actual) && !adjacencyMap.get(actual).isEmpty()) {
                    stack.push(adjacencyMap.get(actual).remove(0));
                } else {
                    circuito.add(stack.pop());
                }
            }



            StringBuilder sb = new StringBuilder();
            for (int i = circuito.size() - 1; i >= 0; i--) {
                sb.append(circuito.get(i).getNombre());
                if (i > 0) {
                    sb.append(" -> ");
                }
            }




            return "Circuito Euleriano: " + sb;
        }
    }

    /**
     * Construye un mapa de adyacencia del grafo.
     *
     * <p>El mapa de adyacencia representa las conexiones entre los nodos del grafo. Cada nodo está
     * asociado con una lista de nodos adyacentes (nodos con los que tiene una conexión directa).</p>
     *
     * @return un mapa donde las claves son nodos y los valores son listas de nodos adyacentes
     */
    private Map<Nodo, List<Nodo>> buildAdjacencyMap() {
        Map<Nodo, List<Nodo>> adjacencyMap = new HashMap<>();
        for (Arista arista : aristas) {
            adjacencyMap.computeIfAbsent(arista.getNodoInicio(), k -> new ArrayList<>()).add(arista.getNodoFin());
            adjacencyMap.computeIfAbsent(arista.getNodoFin(), k -> new ArrayList<>()).add(arista.getNodoInicio());
        }
        return adjacencyMap;
    }

    /**
     * Verifica si el grafo tiene un circuito Euleriano.
     *
     * @return true si el grafo tiene un circuito Euleriano, false en caso contrario
     */
    private boolean isEuleriano() {
        for (Nodo nodo : nodos) {
            int grado = 0;
            for (Arista arista : aristas) {
                if (arista.getNodoInicio() == nodo || arista.getNodoFin() == nodo) {
                    grado++;
                }
            }
            if (grado % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Obtiene el circuito Hamiltoniano del grafo, si existe.
     *
     * @return una cadena que describe el circuito Hamiltoniano si existe, o un mensaje indicando que no existe
     */
    public String getCircuitoHamiltoniano() {
        if (!isHamiltoniano()) {
            return "El grafo no tiene circuito Hamiltoniano.";
        } else {
            List<Nodo> circuito = new ArrayList<>();
            Set<Nodo> visitedNodes = new HashSet<>();
            findHamiltonianCircuit(nodos.get(0), nodos.get(0), visitedNodes, circuito);

            StringBuilder sb = new StringBuilder();
            for (Nodo nodo : circuito) {
                sb.append(nodo.getNombre()).append(" -> ");
            }

            return "Circuito Hamiltoniano: " + sb.toString();
        }
    }

    /**
     * Encuentra un circuito Hamiltoniano en el grafo.
     *
     * @param start el nodo de inicio.
     * @param current el nodo actual.
     * @param visited el conjunto de nodos visitados.
     * @param circuit la lista de nodos en el circuito.
     * @return true si se encuentra un circuito Hamiltoniano, false en caso contrario.
     */
    private boolean findHamiltonianCircuit(Nodo start, Nodo current, Set<Nodo> visited, List<Nodo> circuit) {
        circuit.add(current);
        visited.add(current);

        if (circuit.size() == nodos.size()) {
            // Verificar si el último nodo está conectado al nodo inicial
            for (Arista arista : aristas) {
                if ((arista.getNodoInicio() == current && arista.getNodoFin() == start) ||
                        (arista.getNodoInicio() == start && arista.getNodoFin() == current)) {
                    circuit.add(start);
                    return true;
                }
            }
            circuit.remove(current);
            visited.remove(current);
            return false;
        }

        for (Nodo vecino : getVecinos(current)) {
            if (!visited.contains(vecino)) {
                if (findHamiltonianCircuit(start, vecino, visited, circuit)) {
                    return true;
                }
            }
        }

        circuit.remove(current);
        visited.remove(current);
        return false;
    }

    /**
     * Justifica si el grafo es Hamiltoniano o no.
     *
     * @return una justificación textual sobre la hamiltonicidad del grafo
     */
    public String justificarGrafoHamiltoniano() {
        if (!isHamiltoniano()) {
            StringBuilder justificacion = new StringBuilder("El grafo no es Hamiltoniano debido a: ");

            // Verificar si el grafo tiene menos de tres nodos
            if (getNodos().size() < 3) {
                justificacion.append("tiene menos de tres nodos");
                return justificacion.toString();
            }

            // Comprobar el teorema de Dirac
            boolean cumpleDirac = true;
            for (Nodo nodo : getNodos()) {
                if (nodo.getGrado(this) < getNodos().size() / 2) {
                    cumpleDirac = false;
                    break;
                }
            }
            if (!cumpleDirac) {
                justificacion.append("no cumple con el teorema de Dirac");
                return justificacion.toString();
            }

            // Comprobar el teorema de Ore
            boolean cumpleOre = true;
            for (Nodo nodo1 : getNodos()) {
                for (Nodo nodo2 : getNodos()) {
                    // Solo considerar pares de nodos no adyacentes
                    if (!nodo1.esAdyacente(nodo2, this)) {
                        // Calcular la suma de los grados de los nodos no adyacentes
                        int gradoTotal = nodo1.getGrado(this) + nodo2.getGrado(this);
                        // Si la suma de los grados es menor que el número total de nodos, el grafo no es Hamiltoniano
                        if (!nodo1.esAdyacente(nodo2, this) && gradoTotal < getNodos().size()) {
                            cumpleOre = false;
                            break;
                        }
                    }
                }
                if (!cumpleOre) {
                    break;
                }
            }
            if (!cumpleOre) {
                justificacion.append("no cumple con el teorema de Ore");
                return justificacion.toString();
            }

            // Si no se encontraron razones específicas, devolver un mensaje general
            return "El grafo no es Hamiltoniano debido a razones desconocidas.";
        } else {
            return "El grafo es Hamiltoniano porque cumple con las condiciones necesarias.";
        }
    }

    /**
     * Verifica si el grafo es bipartito.
     *
     * @return true si el grafo es bipartito, false en caso contrario
     */
    public boolean isBipartito() {
        Set<Nodo> conjuntoA = new HashSet<>();
        Set<Nodo> conjuntoB = new HashSet<>();

        // Elegir un nodo aleatorio como nodo inicial
        Nodo nodoInicial = nodos.get(0);
        conjuntoA.add(nodoInicial);

        // Realizar un recorrido en profundidad (DFS) para asignar nodos a conjuntos
        Stack<Nodo> stack = new Stack<>();
        stack.push(nodoInicial);

        while (!stack.isEmpty()) {
            Nodo nodoActual = stack.pop();
            Set<Nodo> conjuntoActual = (conjuntoA.contains(nodoActual)) ? conjuntoA : conjuntoB;

            for (Nodo vecino : getVecinos(nodoActual)) {
                if (!conjuntoA.contains(vecino) && !conjuntoB.contains(vecino)) {
                    // Si el vecino no ha sido asignado a ningún conjunto, asignarlo al contrario del conjunto actual
                    if (conjuntoActual == conjuntoA) {
                        conjuntoB.add(vecino);
                    } else {
                        conjuntoA.add(vecino);
                    }
                    stack.push(vecino);
                } else if (conjuntoActual.contains(vecino)) {
                    // Si el vecino pertenece al mismo conjunto que el nodo actual, el grafo no es bipartito
                    return false;
                }
            }
        }

        // Si no hay conflictos de asignación, el grafo es bipartito
        return true;
    }
    /**
     * Verifica si el grafo es Hamiltoniano.
     * Para que un grafo sea Hamiltoniano, debe cumplir con las siguientes condiciones:
     *     El grafo debe tener al menos tres nodos.
     *         Teorema de Dirac: Cada nodo del grafo debe tener un grado mayor o igual a la mitad del número total de nodos.
     *         Teorema de Ore: La suma de los grados de cada par de nodos no adyacentes debe ser al menos igual al número total de nodos.
     * @return true si el grafo es Hamiltoniano, false en caso contrario
     */
    private boolean isHamiltoniano() {
        // Verificar si el grafo cumple con las condiciones de un grafo Hamiltoniano

        // Si el grafo tiene menos de tres nodos, no puede ser Hamiltoniano
        if (nodos.size() < 3) {
            return false;
        }

        // Comprobar el teorema de Dirac: Si cada nodo tiene un grado mayor o igual a la mitad del número total de nodos
        for (Nodo nodo : nodos) {
            if (nodo.getGrado(this) < nodos.size() / 2) {
                return false;
            }
        }

        // Comprobar el teorema de Ore: La suma de los grados de cada par de nodos no adyacentes es al menos igual al número total de nodos
        for (Nodo nodo1 : nodos) {
            for (Nodo nodo2 : nodos) {
                // Solo considerar pares de nodos no adyacentes
                if (!nodo1.esAdyacente(nodo2, this)) {
                    // Calcular la suma de los grados de los nodos no adyacentes
                    int gradoTotal = nodo1.getGrado(this) + nodo2.getGrado(this);
                    // Si la suma de los grados es menor que el número total de nodos, el grafo no es Hamiltoniano
                    if (!nodo1.esAdyacente(nodo2, this) && gradoTotal < nodos.size()) {
                        return false;
                    }
                }
            }
        }

        // Si pasa todas las condiciones, el grafo es Hamiltoniano
        return true;
    }


    /**
     * Obtiene los vecinos de un nodo en el grafo.
     *
     * @param nodo el nodo para el cual se buscan vecinos
     * @return un conjunto de nodos vecinos
     */
    private Set<Nodo> getVecinos(Nodo nodo) {
        Set<Nodo> vecinos = new HashSet<>();
        for (Arista arista : aristas) {
            if (arista.getNodoInicio() == nodo) {
                vecinos.add(arista.getNodoFin());
            } else if (arista.getNodoFin() == nodo) {
                vecinos.add(arista.getNodoInicio());
            }
        }
        return vecinos;
    }





    public boolean isSimple() {
        // Verificar si hay bucles
        for (Nodo nodo : nodos) {
            if (hasLoop(nodo)) {
                return false;
            }
        }

        // Verificar si hay aristas múltiples
        return !hasMultipleEdges();
    }

    private boolean hasLoop(Nodo nodo) {
        for (Arista arista : aristas) {
            if (arista.getNodoInicio() == nodo && arista.getNodoFin() == nodo) {
                return true;
            }
        }
        return false;
    }

    private boolean hasMultipleEdges() {
        Set<String> aristasSet = new HashSet<>();
        for (Arista arista : aristas) {
            String aristaKey = arista.getNodoInicio().toString() + "-" + arista.getNodoFin().toString();
            if (!aristasSet.add(aristaKey)) {
                return true;
            }
        }
        return false;
    }







    /**
     * Identifica el tipo de grafo (conexo, Euleriano, Hamiltoniano, bipartito).
     *
     * @return una cadena que describe el tipo de grafo
     */
    public String identificarTipo() {
        StringBuilder tipo = new StringBuilder();

        boolean simple = isSimple();
        boolean conexo = isGraphConnected();
        boolean euleriano = isEuleriano();
        boolean hamiltoniano = isHamiltoniano();
        boolean bipartito = isBipartito();

        if (simple) {
            tipo.append("Simple");
        } else {
            tipo.append("No simple");
        }

        tipo.append(", No dirigido, ");

        if (conexo) {
            tipo.append("Conexo");
        } else {
            tipo.append("No conexo");
        }

        tipo.append(", ");

        if (euleriano) {
            tipo.append("Euleriano");
        } else {
            tipo.append("No euleriano");
        }

        tipo.append(", ");

        if (hamiltoniano) {
            tipo.append("Hamiltoniano");
        } else {
            tipo.append("No hamiltoniano");
        }

        tipo.append(", ");

        if (bipartito) {
            tipo.append("Bipartito");
        } else {
            tipo.append("No bipartito");
        }

        return tipo.toString();
    }

    /**
     * Obtiene la matriz de adyacencia del grafo.
     *
     * @return una cadena que representa la matriz de adyacencia del grafo
     */
    public String getMatrizAdyacencia() {
        int size = nodos.size();
        int[][] matriz = new int[size][size];

        // Llenar la matriz de adyacencia
        for (Arista arista : aristas) {
            int indiceInicio = nodos.indexOf(arista.getNodoInicio());
            int indiceFin = nodos.indexOf(arista.getNodoFin());
            matriz[indiceInicio][indiceFin] = 1;
            matriz[indiceFin][indiceInicio] = 1; // Si el grafo es no dirigido, agregar esta línea
        }

        // Construir la cadena de texto con la matriz de adyacencia
        StringBuilder sb = new StringBuilder();
        // Encabezado de la matriz con los nombres de los nodos
        sb.append("\t");
        for (Nodo nodo : nodos) {
            sb.append(nodo.getNombre()).append("\t");
        }
        sb.append("\n");

        // Contenido de la matriz
        for (int i = 0; i < size; i++) {
            sb.append(nodos.get(i).getNombre()).append("\t");
            for (int j = 0; j < size; j++) {
                sb.append(matriz[i][j]).append("\t");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}