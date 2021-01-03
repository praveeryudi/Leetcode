package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _207_Course_Schedule {

    private static List<List<Integer>> adjList;

    private static void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {

        adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add the edges
        for (int[] x : prerequisites) {
            int src = x[1];
            int dest = x[0];
            addEdge(src, dest);
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int d : adjList.get(i)) {
                indegree[d]++;
            }
        }

        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();

        // Add vertices where indegree is 0.
        for (int index = 0; index < indegree.length; index++) {
            if (indegree[index] == 0)
                q.add(index);
        }

        while (!q.isEmpty()) {
            int temp = q.poll();
            cnt++;
            // Process the neighbors of the vertex
            for (int neighbor : adjList.get(temp)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    q.add(neighbor);
            }
        }
        return cnt == numCourses;
    }

    public static void main(String[] args) {

        int numCourses = 6;
        int[][] prerequisites = {
                {1, 0},
                {2, 1},
                {2, 3},
                {3, 0},
                {3, 1},
                {4, 0},
                {4, 1},
                {4, 2},
                {4, 3},
                {4, 5}
        };

        boolean canFinish = canFinish(numCourses, prerequisites);
        System.out.println(canFinish);
    }
}
