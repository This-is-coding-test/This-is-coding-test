import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임_개발 {
    static int N;
    static int M;

    static int[][] map;
    // 0 -> 북 / 1 -> 동 / 2 -> 남 / 3 -> 서

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        game(A, B, d);

        System.out.println(result);



    }

    private static void game(int x, int y, int d) {

        map[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            d = (d + 1) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != 1) {
                if (map[nx][ny] != -1) {
                    game(nx, ny, d);
                    result++;
                    return;
                }
            }
        }

        int back = (d + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];

        if (bx >= 0 && by >= 0 && bx < N && by < M && map[bx][by] != 1) {
            if (map[bx][by] != -1) {
                game(bx, by, d);
            }
        }

        }

}
