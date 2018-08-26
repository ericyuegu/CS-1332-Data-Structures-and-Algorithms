import org.junit.Before;
import org.junit.Test;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Carlos Priddy's tests to catch SOME edge cases
 *
 * @author Carlos Priddy
 * @version 1.0
 */
public class PriddyGoodGraphTests {

    private Graph<Character> directedGraph;
    private Graph<Character> undirectedGraph;

    private static final int TIMEOUT = 200;

    @Before
    public void init() {
        directedGraph = createDirectedGraph();
        undirectedGraph = createUndirectedGraph();
    }

    /**
     * creates a directed graph
     * @return
     */
    private Graph<Character> createDirectedGraph() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 71; i++) {
            vertices.add(new Vertex<>((char) i));
        }
        Set<Edge<Character>> edges = new HashSet<>();

        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 1));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 1));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('G'), 2));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 1));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('E'), 1));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('F'), 1));
        edges.add(new Edge<>(new Vertex<>('G'), new Vertex<>('F'), 2));


        return new Graph<>(vertices, edges);
    }

    /**
     * @return the completed graph
     */
    private Graph<Character> createUndirectedGraph() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 71; i++) {
            vertices.add(new Vertex<>((char) i));
        }

        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('G'), 4));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 7));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 7));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('C'), 5));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('A'), 5));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 2));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 2));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('D'), 4));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('A'), 4));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('E'), 1));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('D'), 1));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('E'), 3));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('B'), 3));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('F'), 8));

        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('B'), 8));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('F'), 6));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('E'), 6));
        edges.add(new Edge<>(new Vertex<>('G'), new Vertex<>('D'), 4));

        return new Graph<>(vertices, edges);
    }

    @Test
    public void testDijkstrasPathWeightsInsteadOfEdgeWeights() {
        //In some circumstances incorrect algorithms will simply add
        //  the weight of the edge of a vertex to the PQ instead
        //  of the cumulative weight to get to that point
        //  This test checks that condition.

        Map<Vertex<Character>, Integer> dijkActual = GraphAlgorithms.dijkstras(
                new Vertex<>('A'), directedGraph);
        Map<Vertex<Character>, Integer> dijkExpected = new HashMap<>();
        dijkExpected.put(new Vertex<>('A'), 0);
        dijkExpected.put(new Vertex<>('B'), 1);
        dijkExpected.put(new Vertex<>('C'), 2);
        dijkExpected.put(new Vertex<>('D'), 3);
        dijkExpected.put(new Vertex<>('E'), 4);
        dijkExpected.put(new Vertex<>('F'), 4);
        dijkExpected.put(new Vertex<>('G'), 2);

        assertEquals(dijkExpected, dijkActual);
    }

    @Test
    public void testKruskalsNonSequentialEdges() {
        //This test makes sure that you are not just removing another
        //  edge from the queue as if the backward edge follows
        //  the forward edge immediately in the PQ.
        //  Graphs with multiple edges with duplicate weights may not
        //  be entered sequentially in the PQ. Try creating a new edge
        //  instead of trying to find the backwards edge in the PQ.
        Set<Edge<Character>> mstActual = GraphAlgorithms.kruskals(
                undirectedGraph);
        Set<Edge<Character>> edges = new HashSet<>();
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('E'), 1));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('D'), 1));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('A'), 4));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('D'), 4));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('B'), 3));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('E'), 3));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 2));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 2));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('E'), 6));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('F'), 6));
        edges.add(new Edge<>(new Vertex<>('G'), new Vertex<>('D'), 4));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('G'), 4));


        assertEquals(edges, mstActual);
    }
}