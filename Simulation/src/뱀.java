import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 뱀 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }


    static int[][] map;
    static int N;

    static int K;

    // 처음 뱀의 길이는 1
    // 매초마다 뱀은 몸길이를 늘려 머리를 다음 칸에 위치시킨다.
    // 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.

    static int L; // 뱀의 방향 변환 정보
    // (X, C) -> X초가 끝난 뒤에 'L' 왼쪽, 'D' 90도 회전
    // 게임 끝나는 시간을 출력
    static List<Integer> times = new ArrayList<>();
    static List<Character> dirs = new ArrayList<>();
    static LinkedList<Point> snake = new LinkedList<>();
    static int time = 0;

    // 시계방향
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int dir = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1]; // 1행 1열부터 시작
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            times.add(time);
            dirs.add(dir);
        }

        snake.add(new Point(1, 1));

        move();

        System.out.println(time);

    }

    private static void move() {

        while (true) {

            time++;

            Point head = snake.getFirst();

            int nx = head.x + dx[dir]; // 1
            int ny = head.y + dy[dir]; // 2

            // 몸에 부딪히는 경우 체크
            if (check(nx, ny)) {
                break;
            }


            if (nx >= 1 && ny >= 1 && nx <= N && ny <= N) {  // 이동 가능
                // 사과 존재 ?
                if (map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    snake.addFirst(new Point(nx, ny));
                } else {
                    snake.addFirst(new Point(nx, ny));
                    snake.removeLast();

                }
            } else { // 이동 불가
                break;
            }



            for (int i = 0; i < times.size(); i++) {
                if (times.get(i) == time) {
                    if (dirs.get(i) == 'L') {
                        dir = (dir + 3) % 4;
                    } else {
                        dir = (dir + 1) % 4;
                    }
                }
            }
        }


    }

    private static boolean check(int nx, int ny) {
        for (int i = 0; i < snake.size(); i++) {
            if(nx == snake.get(i).x && ny == snake.get(i).y) {
                return true;
            }
        }
        return false;
    }
}
