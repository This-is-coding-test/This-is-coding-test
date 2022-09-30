import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 연산자_끼워_넣기 {

    static int N;
    static int[] arr;
    static Map<Integer, Character> op = new HashMap<>();

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[] output; // 0, 1, 2, 3, 4 / 0, 1, 2, 4, 3 / ...
    static int opSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int op1 = Integer.parseInt(st.nextToken()); // +
        int op2 = Integer.parseInt(st.nextToken()); // -
        int op3 = Integer.parseInt(st.nextToken()); // *
        int op4 = Integer.parseInt(st.nextToken()); // /

        opSize = op1 + op2 + op3 + op4;
        mapInit(op1, op2, op3, op4);
        visited = new boolean[opSize];
        output = new int[opSize];

        permutation(0);
        System.out.println(max);
        System.out.println(min);


    }

    private static void permutation(int L) {

        if (L == opSize) {
            calculate();
            return;
        } else {
            for (int i = 0; i < opSize; i++) {

                if (!visited[i]) {
                    visited[i] = true;
                    output[L] = i;
                    permutation(L + 1);
                    visited[i] = false;
                }

            }
        }


    }

    private static void calculate() {

        int sum = arr[0];
        for (int i = 0; i < opSize; i++) {
            Character operator = op.get(output[i]);

            if (operator == '+') {
                sum += arr[i + 1];

            } else if (operator == '-') {
                sum -= arr[i + 1];

            } else if (operator == '*') {
                sum *= arr[i + 1];

            } else {
                if (sum < 0) {
                    sum = Math.abs(sum) / arr[i + 1];
                    sum = -sum;
                }else {
                    sum /= arr[i + 1];
                }
            }
        }
        max = Math.max(max, sum);
        min = Math.min(min, sum);
    }

    private static void mapInit(int op1, int op2, int op3, int op4) {

        int idx = 0;
        for (int i = 0; i < op1; i++) {
            op.put(idx++, '+');
        }
        for (int i = 0; i < op2; i++) {
            op.put(idx++, '-');
        }
        for (int i = 0; i < op3; i++) {
            op.put(idx++, '*');
        }
        for (int i = 0; i < op4; i++) {
            op.put(idx++, '/');
        }

    }
}
