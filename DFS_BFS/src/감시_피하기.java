import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 감시_피하기 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static char[][] map;
    static int N;
    static List<Point> teachers = new ArrayList<>();
    static boolean flag = false;

    // 복도에는 선생님, 학생, 장애물이 존재
    // 선생님은 장애물로 막히기 전까지 4가지 방향으로 학생을 모두 볼 수 있다.
    // 각 칸은 선생님이 존재하면 T, 학생이 존재하면 S, 장애물이 존재하면 O
    // 장애물 3개를 설치하여 모든 학생이 선생님의 감시를 피할 수 있는지 출력

    // 장애물 3개 설치 -> 확인

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'T') {
                    teachers.add(new Point(i, j));
                }
            }
        }

        makeWall(0);

        if (flag) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");

    }

    private static void makeWall(int count) {
        if (flag) return;
        if (count == 3) {
            if (!check()) flag = true;

        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 'X') {
                        map[i][j] = 'O';
                        makeWall(count + 1);
                        map[i][j] = 'X';
                    }
                }
            }
        }


    }

    private static boolean check() {

        for (Point teacher : teachers) {

            for (int i = 0; i < 4; i++) {

                int nx = teacher.x + dx[i];
                int ny = teacher.y + dy[i];

                while (true) {

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        if (map[nx][ny] == 'O') {
                            break;
                        }
                        if (map[nx][ny] == 'S') {
                            return true;
                        }

                        nx += dx[i];
                        ny += dy[i];
                    } else {
                        break;
                    }
                }

            }
        }

        return false;

    }
}
