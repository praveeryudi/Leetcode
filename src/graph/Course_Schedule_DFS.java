package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Course_Schedule_DFS {
	
	private static boolean solve(int[][] matrix) {
        // Write your code here
        
        int numCourses = matrix.length;
        List<LinkedList<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++)
            adjList.add(new LinkedList<>());
        
        for(int index = 0; index < numCourses; index++) {
            
            int[] prerequisites = matrix[index];
            for(int n : prerequisites)
            	adjList.get(index).add(n);
        }
        
        int[] indegree = new int[numCourses];
        for(int index = 0; index < numCourses; index++) {
        	for(int c : adjList.get(index))
        		indegree[c]++;
        }
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < indegree.length; i++) {
        	if(indegree[i] == 0)
        		st.push(i);
        }
        if(st.isEmpty())
        	return false;
        
//        visited[startVertex] = true;
        int count = 0;
        while(!st.isEmpty()) {
            Integer curr = st.pop();
            System.out.print(curr + " ");
            visited[curr] = true;
            count++;
            for(Integer neighbor : adjList.get(curr)) {
                if(!visited[neighbor]) {
                	//visited[neighbor] = true;
                	st.push(neighbor);
                }
            }
        }
        
        return count == numCourses;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = {
				{},
				{}
		};
		boolean canFinish = solve(matrix);
		System.out.println(canFinish);
	}

}
