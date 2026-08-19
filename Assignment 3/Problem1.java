import java.util.*;

public class Problem1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long B = sc.nextLong();

        long[] scholarship = new long[N];

        for (int i = 0; i < N; i++) {
            scholarship[i] = sc.nextLong();
        }

        Arrays.sort(scholarship);

        long total = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {

            if (total + scholarship[i] <= B) {
                total += scholarship[i];
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);

        sc.close();
    }
}
