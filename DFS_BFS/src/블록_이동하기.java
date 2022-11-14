import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class 블록_이동하기 {

    static class Item {
        int x1, x2, y1, y2, time, vertical;

        public Item(int x1, int y1, int x2, int y2, int time, int vertical) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
            this.time = time;
            this.vertical = vertical;
        }
    }

    // 로봇은 2 x 1 크기의 로봇으로 "무지"는 "0"과 "1"로 이루어진 N x N 크기의 지도에서 2x1 크기인 로봇을 움직여 (N, N) 위치까지 이동할 수 있도록 프로그래밍
    // "0"은 빈칸, "1"은 벽을 나타낸다.

    // 로봇이 움직일 때는 현재 놓여있는 상태를 유지하면서 이동한다.
    //

    static int N;
    int[][] op = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] map;
    static boolean[][][] visited;
    static Queue<Item> queue = new LinkedList<>();
    static int answer = 0;

    public int solution(int[][] board) {
        N = board.length - 1;
        map = board.clone();
        visited = new boolean[board.length][board.length][2];
        queue.offer(new Item(0, 0, 0, 1, 0, 0));
        BFS();
//        DFS(0, 0, 0, 1, 0);
        return answer;
    }

    private void BFS() {
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (item.x1 < 0 || item.x1 >= map.length || item.y1 < 0 || item.y1 >= map.length ||
                    item.x2 < 0 || item.x2 >= map.length || item.y2 < 0 || item.y2 >= map.length) {
                continue;
            }

            if (map[item.x1][item.y1] == 1 || map[item.x2][item.y2] == 1) {
                continue;
            }

            if (visited[item.x1][item.y1][item.vertical] &&
                    visited[item.x2][item.y2][item.vertical])
                continue;


            if ((item.x1 == map.length - 1 && item.y1 == map.length - 1) ||
                    (item.x2 == map.length - 1 && item.y2 == map.length - 1)) {
                answer = item.time;
                break;
            }

            visited[item.x1][item.y1][item.vertical] = true;
            visited[item.x2][item.y2][item.vertical] = true;

            for (int i = 0; i < 4; i++) {
                int nlx = item.x1 + op[i][0];
                int nly = item.y1 + op[i][1];
                int nrx = item.x2 + op[i][0];
                int nry = item.y2 + op[i][1];

                queue.offer(new Item(nlx, nly, nrx, nry, item.time + 1, item.vertical));
            }


            // x1 = 1, y1 = 2
            // x2 = 2, y2 = 2


            if (item.vertical == 1) {
                if (item.y1 - 1 >= 0 && map[item.x1][item.y1 - 1] == 0 && map[item.x2][item.y2 - 1] == 0) {
                    queue.offer(new Item(item.x1, item.y1, item.x1, item.y1 - 1, item.time + 1, 0));
                    queue.offer(new Item(item.x2, item.y2, item.x2, item.y2 - 1, item.time + 1, 0));
                }

                if (item.y1 + 1 <= (map.length - 1) &&
                        map[item.x1][item.y1 + 1] == 0 && map[item.x2][item.y2 + 1] == 0) {
                    queue.offer(new Item(item.x1, item.y1, item.x1, item.y1 + 1, item.time + 1, 0));
                    queue.offer(new Item(item.x2, item.y2, item.x2, item.y2 + 1, item.time + 1, 0));
                }
            } else {
                if (item.x1 - 1 >= 0 && map[item.x1 - 1][item.y1] == 0 &&
                        map[item.x2 - 1][item.y2] == 0) {
                    queue.offer(new Item(item.x1, item.y1, item.x1 - 1, item.y1, item.time + 1, 1));
                    queue.offer(new Item(item.x2, item.y2, item.x2 - 1, item.y2, item.time + 1, 1));
                }

                if (item.x1 + 1 <= (map.length - 1) && map[item.x1 + 1][item.y1] == 0 &&
                        map[item.x2 + 1][item.y2] == 0) {
                    queue.offer(new Item(item.x1, item.y1, item.x1 + 1, item.y1, item.time + 1, 1));
                    queue.offer(new Item(item.x2, item.y2, item.x2 + 1, item.y2, item.time + 1, 1));
                }
            }


        }
    }


    public static void main(String[] args) throws IOException {
        블록_이동하기 sol = new 블록_이동하기();
        int result = sol.solution(new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}});
        System.out.println(result);

    }
}
