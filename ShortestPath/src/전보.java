import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 전보 {

    // 어떤 나라에는 N개의 도시가 존재
    // 각 도시는 보내고자 하는 메시지가 있는 경우, 다른 도시로 전보를 보내서 다른 도시로 해당 메시지를 전송할 수 있다.
    // 하지만 X라는 도시에서 Y라는 도시로 전보를 보내고자 한다면, 도시 X에서 Y로 향하는 통로가 설치되어 있어야 한다.

    // 예를 들어 X에서 Y로 향하는 통로는 있지만, Y에서 X로 향하는 통로가 없다면 Y는 X로 메시지를 보낼 수 없다.

    // 어느 날 C라는 도시에서 위급 상황이 발생했다.
    // 그래서 최대한 많은 도시로 메시지를 보내고자 한다. 메시지는 도시 C에서 출발하여 각 도시 사이에 설치된 통로를 거쳐,
    // 최대한 많이 퍼져나갈 것이다.


    /**
     * 도시 C에서 보낸 메시지를 받게 되는 도시의 개수는 총 몇개이며 도시들이 모두 메시지를 받는 데까지 걸리는 시간을 얼마인지 계산하는 프로그램을 작성하시오.
     */

    static class Edge {
        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
    }

    static int N; // 도시의 개수
    static int M; // 통로의 개수
    static int C; // 메시지를 보내고자 하는 도시

    static int[] dist;
    static List<ArrayList<Edge>> edges = new ArrayList<>();
    static PriorityQueue<Edge> pQ = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

    public static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int Z = Integer.parseInt(st.nextToken());

            edges.get(X).add(new Edge(Y, Z));
            edges.get(Y).add(new Edge(X, Z));
        }

        pQ.offer(new Edge(C, 0));
        Arrays.fill(dist, INF);
        dist[C] = 1;
        dijkstra();

        int time = Integer.MIN_VALUE;
        int count = -1;
        for (int i = 1; i <= N; i++) {

            if (dist[i] != INF) {
                time = Math.max(time, dist[i]);
                count++;
            }
        }

        System.out.print(count + " " + time);


    }

    private static void dijkstra() {

        while (!pQ.isEmpty()) {

            Edge e = pQ.poll();
            int vex = e.vex;
            int cost = e.cost;

            if (dist[vex] < cost) continue;

            for (Edge edge : edges.get(vex)) { // 3, 4

                if (dist[edge.vex] > cost + edge.cost) {
                    dist[edge.vex] = cost + edge.cost;
                    pQ.offer(new Edge(edge.vex, edge.cost + cost));
                }
            }
        }


    }
}
