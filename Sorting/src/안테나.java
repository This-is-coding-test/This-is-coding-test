import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 안테나 {
    static int N;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        dist = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dist);

        if (N % 2 == 0) {
            System.out.println(dist[N / 2 - 1]);
        } else {
            System.out.println(dist[N / 2]);
        }


    }
}
