import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 만들_수_없는_금액 {

    static int N;

    // N개의 동전을 이용하여 만들 수 없는 양의 정수 금액 중 최솟값
    // 3,2,1,1,9

    static int[] coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coins);
        int target = 1; // 1 -> 2 -> 3 -> 5 -> 8
        // target == 1: 0 까지는 만들 수 있음
        // target == 2: 1 까지는 만들 수 있음
        // target == 3: 2 까지는 만들 수 있음
        for (int coin : coins) {

            if (coin <= target) { // 1 1 2 3 9
                target += coin;
            } else {
                break;
            }
        }

        System.out.println(target);


    }
}
