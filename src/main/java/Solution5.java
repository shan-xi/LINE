import java.util.ArrayList;
import java.util.List;

public class Solution5 {
    class Solution {

        public Boolean solution(int size, int[] edges) {
            Graph g = new Graph(size);
            for (int i = 0; i < edges.length; i += 2) {
                System.out.println(edges[i] + " " + edges[i + 1]);
                g.addEdge(edges[i], edges[i + 1]);
            }
            return g.isCyclic();
        }

        private class Graph {
            private final int V;
            private final List<List<Integer>> adj;

            Graph(int V) {
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

            private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
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
    }

    public static void main(String[] args) {
        Solution5.Solution s = new Solution5().new Solution();
        System.out.println(s.solution(4, new int[]{0, 1, 1, 2, 2, 3, 3, 0}));
        System.out.println(s.solution(3, new int[]{0, 1, 1, 2, 2, 0}));
        System.out.println(s.solution(0, new int[]{}));
        System.out.println(s.solution(4, new int[]{0, 0, 0, 1, 1, 2, 2, 3}));
        System.out.println(s.solution(4, new int[]{0, 1, 1, 2, 2, 3}));
        System.out.println(s.solution(4, new int[]{0, 1, 1, 2, 2, 3, 3, 2}));
        System.out.println(s.solution(2, new int[]{0, 1}));
        System.out.println(s.solution(2, new int[]{0, 1, 1, 0}));
        System.out.println(s.solution(3, new int[]{0, 1, 1, 2, 2, 0}));
    }
}
