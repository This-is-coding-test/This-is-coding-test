import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


// combination ?
public class 볼링공_고르기 {

    static class Ball {
        int idx;
        int weight;

        public Ball(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static int N;
    static int M;
    static int[] output = new int[2];
    static List<Ball> balls = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int weight = Integer.parseInt(st.nextToken());
            balls.add(new Ball(i, weight));
        }


        combination(0, 0);

        System.out.println(result);


    }

    private static void combination(int depth, int start) {
        if (depth == 2) {
            if (balls.get(output[0]).weight != balls.get(output[1]).weight) {
                result++;
            }
        } else {
            for (int i = start; i < N; i++) {
                output[depth] = i;
                combination(depth + 1, i + 1);
            }
        }

    }
}
