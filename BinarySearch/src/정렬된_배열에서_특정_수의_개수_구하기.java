import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 정렬된_배열에서_특정_수의_개수_구하기 {

    static int N;
    static int x;

    static List<Integer> list = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        binarySearch();
        if (result == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }

    private static void binarySearch() {

        int lt = 0;
        int rt = list.size() - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (list.get(mid) < x) {
                lt = mid + 1;
            } else if (list.get(mid) > x) {
                rt = mid - 1;
            } else {
                list.remove(mid);
                rt = list.size() - 1;
                result++;

            }
        }


    }
}
