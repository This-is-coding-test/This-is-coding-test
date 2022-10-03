import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수_삼각형 {

    static int[][] dp;
    static int[][] map;

    static int n;

    static int[] dx = {-1, -1};
    static int[] dy = {-1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        dp = new int[n][n];
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dp[0][0] = map[0][0];

        down();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        System.out.println(max);

    }

    private static void down() {

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {

                for (int k = 0; k < 2; k++) {
                    // 다시
                    int nx = i + dx[k]; // 1 -> 0
                    int ny = j + dy[k]; // 1 -> 0

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {

                        dp[i][j] = Math.max(dp[i][j], map[i][j] + dp[nx][ny]);

                    }
                }


            }

        }


    }
}
