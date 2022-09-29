import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소 {

    // 바이러스
    // 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.
    // 연구소는 크기가 N x M 인 직사각형으로 나타낸다.
    // 바이러스는 상하좌우 인접한 빈칸으로 퍼져갈 수 있다.
    // 새로 세울 수 있는 벽의 개수는 3개
    // 벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다.
    // 안전영역의 최댓값?

    // 벽 3개 세우고(재귀) -> 바이러스 퍼뜨리기(BFS)  반복

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

    static Queue<Point> queue = new LinkedList<>();
    static List<Point> virus = new ArrayList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virus.add(new Point(i, j));
            }
        }

        makeWall(0);

        System.out.println(max);


    }

    private static void makeWall(int count) {
        if (count == 3) {
            for (Point v : virus) {
                queue.offer(v);
            }
            int[][] copy = copyMap();
            spread(copy);
            max = Math.max(max, counting(copy));
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        makeWall(count + 1);
                        map[i][j] = 0;
                    }
                }
            }
        }

    }

    private static int counting(int[][] copy) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    private static int[][] copyMap() {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }

        return copy;

    }

    private static void spread(int[][] copyMap) {
        while (!queue.isEmpty()) {

            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && copyMap[nx][ny] == 0) {
                    copyMap[nx][ny] = -1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

    }
}
