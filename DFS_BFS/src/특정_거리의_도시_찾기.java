import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정_거리의_도시_찾기 {


    static List<ArrayList<Integer>> edges = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static int[] dist;

    // 어떤 나라에는 1 ~ N 번까지의 도시와 M개의 단뱡향 도로가 존재한다
    // 이때 특정한 도시 X 로부터 출발하여 도달할 수 있는 모든 도시 중에서, 최단 거리가 정확히 K인 모든 도시의 번호를 출력

    static int N, M, K, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            edges.get(v1).add(v2);

        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;
        queue.offer(X);

        BFS();

        boolean check = false;
        for (int i = 1; i <= N; i++) {

            if (dist[i] == K) {
                System.out.println(i);
                check = true;
            }
        }

        if (!check) System.out.println(-1);
    }

    private static void BFS() {

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (Integer edge : edges.get(now)) {

                if (dist[edge] == Integer.MAX_VALUE) {
                    dist[edge] = dist[now] + 1;
                    queue.offer(edge);
                }
            }

        }

    }
}
