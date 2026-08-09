import java.util.*;

public class Problem1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        int n = sc.nextInt();
        int k = sc.nextInt();

        
        int[] key = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            key[i] = sc.nextInt();
        }

        // Adjacency list to represent the tree
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Read the n - 1 edges
        for (int i = 0; i < n - 1; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            // Tree is undirected
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        
        int[] pathXor = new int[n + 1];

        // Store parent of each server
        int[] parent = new int[n + 1];

        // Server 1 is the root
        pathXor[1] = key[1];

        // Queue for BFS traversal
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        int trustedCount = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            // Check whether the current server is trusted
            if (pathXor[current] >= k) {
                trustedCount++;
            }

            // Visit all neighbouring servers
            for (int next : graph.get(current)) {

                // Don't go back to the parent
                if (next == parent[current]) {
                    continue;
                }

                // Set current server as the parent
                parent[next] = current;

                // Calculate XOR from Server 1 to this server
                pathXor[next] = pathXor[current] ^ key[next];

                queue.add(next);
            }
        }

        // Print the answer
        System.out.println(trustedCount);

        sc.close();
    }
}
