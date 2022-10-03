import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_DFS {

    public static class Consulting {
        int T;
        int P;

        public Consulting(int t, int p) {
            T = t;
            P = p;
        }
    }

    static int N;
    static Consulting[] consultings;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        consultings = new Consulting[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            consultings[i] = new Consulting(T, P);
        }

        DFS(0 , 0);

        System.out.println(max);


    }

    private static void DFS(int depth, int sum) {
        if (depth >= N) {
            max = Math.max(max, sum);
        } else {
            if (depth + consultings[depth].T <= N) {
                DFS(depth + consultings[depth].T, sum + consultings[depth].P);
            }
//            else {
//                DFS(depth + consultings[depth].T, sum);
//            }
            DFS(depth + 1, sum);

        }

    }
}
