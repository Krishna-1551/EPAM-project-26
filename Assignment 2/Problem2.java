import java.util.*;

public class Problem2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of cities, roads, and maximum allowed distance
        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        // Adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Read roads
        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            // Undirected graph
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Distance of every city from City 1
        int[] distance = new int[n + 1];

        // -1 means the city has not been visited
        Arrays.fill(distance, -1);

        // BFS queue
        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from City 1
        distance[1] = 0;
        queue.add(1);

        int reachableCount = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            // Count city if its shortest distance is <= D
            if (distance[current] <= d) {
                reachableCount++;
            }

            // Visit neighbouring cities
            for (int next : graph.get(current)) {

                if (distance[next] == -1) {

                    distance[next] = distance[current] + 1;

                    queue.add(next);
                }
            }
        }

        System.out.println(reachableCount);

        sc.close();
    }
}