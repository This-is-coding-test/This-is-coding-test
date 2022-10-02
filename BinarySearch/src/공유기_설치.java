import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기_설치 {

    static int N; // 집의 개수
    static int C; // 공유기의 개수

    static int max = Integer.MIN_VALUE;
    static int[] house;
    static int result = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(br.readLine());
            house[i] = p;
            max = Math.max(max, p);
        }

        Arrays.sort(house);

        binarySearch();

        System.out.println(result);

    }

    private static void binarySearch() {
        int lt = 1;
        int rt = max;
        while (lt <= rt) {

            int mid = (lt + rt) / 2;
            if (check(mid)) {
                result = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

    }

    private static boolean check(int mid) {

        int prev = house[0];
        int k = 1; // 3

        for (int i = 1; i < N; i++) {
            if (house[i] - prev >= mid) {
                k++;
                prev = house[i];
            }
        }
        return k >= C;


    }
}
