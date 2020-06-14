package array;

import java.util.*;

public class _207_Topological_Sort {

    private static List<List<Integer>> adjList;
    private int numVertices;
    private int[] inDegree;

    // Constructor
    private _207_Topological_Sort(int numVertices) {
        this.numVertices = numVertices;
        this.inDegree = new int[numVertices];
        adjList = new ArrayList<>(numVertices);
        for(int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    private void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
    }

    public static void main(String[] args) {
        _207_Topological_Sort g = new _207_Topological_Sort(6);
        /*g.addEdge(1, 0);
        g.addEdge(0, 1);*/
        g.addEdge(5, 0);
        g.addEdge(5, 2);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println(adjList);

        boolean isCyclic = g.isCyclicIterative();
        System.out.println("Graph has cycle = " + isCyclic);
        //g.doTopSort();
    }

    private boolean isCyclicIterative() {
        // Populate inDegree array
        for(int i = 0; i < numVertices; i++) {
            for(int d : adjList.get(i)) {
                inDegree[d]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        // Add indices from indegree array where it is 0
        for(int index = 0; index < inDegree.length; index++) {
            if(inDegree[index] == 0)
                q.add(index);
        }
        int cnt = 0;
        List<Integer> topSort = new ArrayList<>();
        while(!q.isEmpty()) {
            int temp = q.poll();
            topSort.add(temp);
            cnt++;
            for(int neighbor : adjList.get(temp)) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0)
                    q.add(neighbor);
            }
        }
        System.out.println(topSort);
        return cnt != numVertices;
    }

    private void doTopSort() {

        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[numVertices];
        Arrays.fill(visited, false);
        for(int i = 0; i < numVertices; i++) {
            if(!visited[i]) {
                helper(st, visited, i);
            }
        }
        // Print the contents
        while(!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    private void helper(Stack<Integer> st, boolean[] visited, int index) {
        if(visited[index])
            return;

        visited[index] = true;
        Iterator<Integer> listItr = adjList.get(index).iterator();
        while(listItr.hasNext()) {
            int neighbor = listItr.next();
            if(!visited[neighbor]) {
                helper(st, visited, neighbor);
            }
        }
        st.push(index);
    }
}