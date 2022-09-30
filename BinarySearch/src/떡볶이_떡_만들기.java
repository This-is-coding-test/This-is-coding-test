import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 떡볶이_떡_만들기 {

    static int N;
    static int M;
    static int[] riceCake;
    static int max = Integer.MIN_VALUE;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        riceCake = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            riceCake[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, riceCake[i]);
        }

        binarySearch();
        System.out.println(answer);



    }

    private static void binarySearch() {
        int lt = 0;
        int rt = max;
        while (lt <= rt) {

            int mid = (lt + rt) / 2;

            int result = cut(mid);

            if (result < M) {
                rt = mid - 1;
            }else {
                answer = mid;
                lt = mid + 1;
            }

        }

    }

    private static int cut(int mid) {

        int sum = 0;
        for (int rc : riceCake) { //
            int length = rc - mid;
            if (length > 0) {
                sum += length;
            }
        }

        return sum;

    }
}
