import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로_탈출 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }

        queue.offer(new Point(1, 1));

        BFS();
        System.out.println(map[N][M]);


    }

    private static void BFS() {
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx > 0 && ny > 0 && nx <= N && ny <= M && map[nx][ny] == 1) {
                    map[nx][ny] = map[p.x][p.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }

        }

    }
}
