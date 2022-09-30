import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부품찾기 {
    static int N;
    static int[] arr;
    static int M;
    static int[] targets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        targets = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        for (int target : targets) {
            if (binarySearch(target)) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }





    }

    private static boolean binarySearch(int target) {

        int lt = 0;
        int rt = arr.length - 1;

        while (lt <= rt) {

            int mid = (lt + rt) / 2;

            if (arr[mid] > target) {
                rt = mid - 1;
            } else if (arr[mid] < target) {
                lt = mid + 1;
            }else {
                return true;
            }
        }

        return false;

    }
}
