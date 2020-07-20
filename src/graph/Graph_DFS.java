package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Graph_DFS {
	
	private Map<Integer, LinkedList<Integer>> adjList;
	private boolean[] visited;
	
	Graph_DFS(int numVertices) {
		this.adjList = new HashMap<>(numVertices);
		for(int i = 0; i < numVertices; i++) {
			this.adjList.put(i, new LinkedList<>());
		}
		this.visited = new boolean[numVertices];
	}
	
	private void addEdge(int source, int target) {
		this.adjList.get(source).add(target);
	}
	
	private void dfs(int start) {
		Stack<Integer> st = new Stack<>();
		
		st.push(start);
		while(!st.isEmpty()) {
			int curr = st.pop();
			visited[curr] = true;
			System.out.print(curr + " ");
			// Get adjacent vertex
			for(int neighbor : adjList.get(curr)) {
				if(!visited[neighbor]) {
					st.push(neighbor);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph_DFS graph = new Graph_DFS(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		
		graph.dfs(0);
		
	}

}
