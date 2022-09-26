import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일이_될_때까지 {

    static int N;
    static int K;

    // N이 1이 될 때까지 두 과정 중 하나를 반복적으로 수행
    // 1. N에서 1을 뺀다.
    // 2. N을 K로 나눈다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while (N != 1) {

            if (N % K == 0) {
                N = N / K;
            }else {
                N = N - 1;
            }
            cnt++;
        }

        System.out.println(cnt);

    }
}
