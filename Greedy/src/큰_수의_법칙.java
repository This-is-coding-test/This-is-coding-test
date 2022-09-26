import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 큰_수의_법칙 {

    static int N, M, K;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Collections.reverseOrder());

        int first = list.get(0); // 제일 큰 수
        int second = list.get(1); // 다음으로 큰 수

        int cnt = 0;
        int result = 0;
        for (int i = 0; i < M; i++) {

            if (cnt < K) {
                result += first;
                cnt++;
            } else {
                result += second;
                cnt = 0;
            }

        }

        System.out.println(result);

    }
}
