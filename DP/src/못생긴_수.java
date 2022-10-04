import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 못생긴_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ugly = new int[N];
        ugly[0] = 1;

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int next2 = 2;
        int next3 = 3;
        int next5 = 5;
        for (int i = 1; i < N; i++) {

            ugly[i] = Math.min(next2, next3);
            ugly[i] = Math.min(ugly[i], next5);

            if (ugly[i] == next2) {
                i2 += 1;
                next2 = ugly[i2] * 2;
            }
            if (ugly[i] == next3) {
                i3 += 1;
                next3 = ugly[i3] * 3;
            }
            if (ugly[i] == next5) {
                i5 += 1;
                next5 = ugly[i5] * 5;
            }

        }

        System.out.println(ugly[N - 1]);

    }
}
