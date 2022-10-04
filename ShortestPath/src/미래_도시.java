import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미래_도시 {

    static class Edge {
        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
    }


    // 판매원 A는 1번에 위치해있고 X번 회사에 방문해 물건을 판매하고자 한다.
    // 소개팅 상대는 K번 회사에 존재한다.

    // A는 X번 회사에 가서 물건을 판매하기 전에 먼저 소개팅 상대의 회사에 찾아가서 함께 커피를 마실 예정이다.
    // 따라서 A -> K -> X 목적

    static int N; // 전체 회사 개수
    static int M; // 경로의 개수

    static int X; // 도착 위치
    static int K; // 소개팅 상대 위치

    static int[] dist;
    static List<ArrayList<Edge>> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            edges.get(start).add(new Edge(end, 1));
            edges.get(end).add(new Edge(start, 1));
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = 0;
        int dist1 = go(1, K);
        result += dist1;
        int dist2 = go(K, X);
        result += dist2;

        if (dist1 == 1000001 || dist2 == 1000001) {
            System.out.println(-1);
            return;
        }

        System.out.println(result);


    }

    private static int go(int start, int end) {
        dist = new int[N + 1];
        Arrays.fill(dist, 1000001);
        dist[start] = 1;

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        queue.offer(new Edge(start, 0));

        while (!queue.isEmpty()) {

            Edge e = queue.poll();
            int vex = e.vex;
            int cost = e.cost;

            if (dist[vex] < cost) continue;

            for (Edge edge : edges.get(vex)) { // 3, 4

                if (dist[edge.vex] > cost + edge.cost) {
                    dist[edge.vex] = cost + edge.cost;
                    queue.offer(new Edge(edge.vex, edge.cost + cost));
                }
            }
        }
        return dist[end];
    }
}
