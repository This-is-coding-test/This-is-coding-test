import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 경쟁적_전염 {
    static class Point {
        int x;
        int y;
        int val;

        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

    }

    // N x N 크기의 시험관
    // 특정 위치에 바이러스가 존재할 수 있다.
    // 바이러스의 종류는 1 ~ K
    // 바이러스는 1초마다 상하좌우 방향으로 증식
    // 매초 번호가 낮은 종류의 바이러스부터 먼저 증식

    static int time = 0;
    static int N, K;
    static int[][] map;
    static int S, X, Y; // S초 뒤에 (X, Y)에 존재하는 바이러스 종류 출력
    static PriorityQueue<Point> pQ = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    pQ.offer(new Point(i, j, map[i][j]));

                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        BFS();


        System.out.println(map[X][Y]);


    }

    private static void BFS() {
        while (!pQ.isEmpty()) {
            if (time == S) {
                break;
            }
            int len = pQ.size();
            List<Point> virus = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                Point p = pQ.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx > 0 && ny > 0 && nx <= N && ny <= N && map[nx][ny] == 0) {
                        map[nx][ny] = p.val;
                        virus.add(new Point(nx, ny, p.val));
                    }

                }
            }

            for (Point point : virus) {
                pQ.offer(point);
            }
            time++;
        }
    }
}
