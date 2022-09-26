import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자_카드_게임 {

    static int N;
    static int M;

    // 먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택
    // 그다음 선택된 행에 포함된 카드들 중 가장 숫자가 낮은 카드를 뽑는다.
    // 따라서 처음에 카드를 골라낼 행을 선택할 때, 이후에 해당 행에서 가장 숫자가 낮은 카드를 뽑을 것을 고려하여 최종적으로 가장 높은 숫자의 카드를 뽑을 수 있도록 전략을 세워야 한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                min = Math.min(min, tmp);
            }
            max = Math.max(max, min);
        }

        System.out.println(max);





    }
}
