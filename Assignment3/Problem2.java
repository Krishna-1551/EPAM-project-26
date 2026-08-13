import java.util.*;

public class Problem2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[] points = new long[N];

        for (int i = 0; i < N; i++) {
            points[i] = sc.nextLong();
        }

        if (N == 0) {
            System.out.println(0);
            return;
        }

        if (N == 1) {
            System.out.println(points[0]);
            return;
        }

        long[] dp = new long[N];

        dp[0] = points[0];

        dp[1] = Math.max(points[0], points[1]);

        for (int i = 2; i < N; i++) {

            long skip = dp[i - 1];

            long take = points[i] + dp[i - 2];

            dp[i] = Math.max(skip, take);
        }

        System.out.println(dp[N - 1]);

        sc.close();
    }
}
