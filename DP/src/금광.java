import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 금광 {

    // n x m 크기의 금광 존재
    // 금광은 1 x 1 크기의 칸으로 나누어져 있으며, 각 칸은 특정한 크기의 금이 들어 있습니다.
    // 채굴자는 첫 번째 열부터 출발하여 금을 캐기 시작

    // 시작은 첫번째 열 어느 행에서든 출발
    // 오른쪽, 오른쪽 위, 오른쪽 아래

    static int N;
    static int M;

    static int[][] map;
    static int[][] dp;

    static int[] dx = {-1, 0, 1};
    static int[] dy = {-1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());


        while (T != 0) {
            T--;

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            dp = new int[N][M];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (j == 0) {
                        dp[i][j] = map[i][j];
                    }
                }
            }
            mine();

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                max = Math.max(max, dp[i][M - 1]);
            }
            sb.append(max).append("\n");

        }

        System.out.println(sb);


    }

    private static void mine() {

        for (int i = 1; i < M; i++) { // 1, 2, 3 -> 열
            for (int j = 0; j < N; j++) { // 0, 1, 2 -> 행

                for (int k = 0; k < 3; k++) {
                    // 다시
                    int nx = j + dx[k]; // 1
                    int ny = i + dy[k]; // 0

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        dp[j][i] = Math.max(dp[j][i], map[j][i] + dp[nx][ny]);
                    }

                }
            }
        }

    }


}
