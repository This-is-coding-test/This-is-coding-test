import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 카드_정렬하기 {
    // 정렬된 두 묶음의 숫자 카드가 있을 때 각 묶음의 카드의 수를 A, B라 하면 보통 두 묶음을 합쳐서 하나로 만드는 데에는 A + B번의 비교를 해야한다.

    static int N;
    static int result = 0;

    static PriorityQueue<Integer> pQ = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(br.readLine());
            pQ.offer(card);
        }

        while (pQ.size() > 1) {
            int A = pQ.poll(); // 10, 30
            int B = pQ.poll(); // 20, 40

            result += A + B; // 30, 100
            pQ.offer(A + B); // 30, 40

        }

        System.out.println(result);


    }
}
