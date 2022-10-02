import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 고정점_찾기 {
    static int[] arr;
    static int N;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        binarySearch();

        System.out.println(result);
    }

    private static void binarySearch() {
        int lt = 0;
        int rt = arr.length - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (arr[mid] < mid) {
                lt = mid + 1;
            } else if (arr[mid] > mid) {
                rt = mid - 1;

            } else {
                result = mid;
                return;
            }

        }
    }
}
