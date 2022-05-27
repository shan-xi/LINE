import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DetectCycle {
    class Graph {
        private final int V;
        private final List<List<Integer>> adj;

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        private void addEdge(int source, int dest) {
            adj.get(source).add(dest);
        }

        boolean isCyclic() {
            boolean[] visited = new boolean[V];
            boolean[] recStack = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (isCyclicUtil(i, visited, recStack)) {
                    return true;
                }
            }
            return false;
        }

        boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
            if (recStack[i]) {
                return true;
            }
            if (visited[i]) {
                return false;
            }

            recStack[i] = true;
            visited[i] = true;
            List<Integer> children = adj.get(i);
            for (int c : children) {
                if (isCyclicUtil(c, visited, recStack)) {
                    return true;
                }
            }

            recStack[i] = false;

            return false;
        }
    }

    public static void main(String[] args) {
        Graph g0 = new DetectCycle().new Graph(4);
        g0.addEdge(0, 1);
        g0.addEdge(1, 2);
        g0.addEdge(2, 3);
        System.out.println(g0.isCyclic());

        Graph g = new DetectCycle().new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        System.out.println(g.isCyclic());

        Graph g1 = new DetectCycle().new Graph(4);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        System.out.println(g1.isCyclic());

        Graph g2 = new DetectCycle().new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.addEdge(2, 0);
        System.out.println(g2.isCyclic());

        Graph g3 = new DetectCycle().new Graph(4);
        g3.addEdge(0, 1);
        g3.addEdge(0, 2);
        g3.addEdge(1, 2);
        g3.addEdge(2, 3);
        g3.addEdge(3, 3);
        System.out.println(g3.isCyclic());
    }
}
