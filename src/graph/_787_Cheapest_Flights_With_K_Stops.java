package graph;

import java.util.PriorityQueue;

public class _787_Cheapest_Flights_With_K_Stops {

    public static void main(String[] args) {
        int[][] flights = new int[][]{
                {0,1,100},
                {1,2,100},
                {0,2,500}
        };
        int cost = getCheapestFlight(flights, 0, 2, 1, 3);
        System.out.println("Cheapest Price = " + cost);
    }

    private static int getCheapestFlight(int[][] flights, int src, int dest, int k, int n) {
        int[][] graph = new int[n][n];
        for(int[] entry : flights) {
            graph[entry[0]][entry[1]] = entry[2];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, k+1});
        while(!pq.isEmpty()) {
            int[] route = pq.poll();
            int price = route[0];
            int city = route[1];
            int remStops = route[2];

            if(city == dest)
                return price;
            if(remStops > 0) {
                for(int i = 0; i < n; i++) {
                    if(graph[city][i] > 0) {
                        pq.offer(new int[]{price + graph[city][i], i, remStops-1});
                    }
                }
            }
        }
        return -1;
    }

}
