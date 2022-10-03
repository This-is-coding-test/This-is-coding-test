import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {

    public static class Consulting {
        int T;
        int P;

        public Consulting(int t, int p) {
            T = t;
            P = p;
        }
    }

    static int N;
    static int[] dp;
    static Consulting[] consultings;

    // N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담
    // 각각의 상담은 상담을 완료하는 데 걸리는 기간 T와 상담을 했을 때 받을 수 있는 금액 P로 이루어져 있습니다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        consultings = new Consulting[N + 2];
        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            consultings[i] = new Consulting(T, P);
        }

        for (int i = N; i > 0; i--) {
            int next = i + consultings[i].T;

            if (next >= N + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], dp[next] + consultings[i].P);
            }

        }

        System.out.println(dp[1]);


    }
}
