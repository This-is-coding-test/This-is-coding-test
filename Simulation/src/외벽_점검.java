public class 외벽_점검 {

    // 레스토랑의 구조는 완벽히 동그란 모양
    // 외벽의 총 둘레는 n미터
    // 외벽의 몇몇 지점은 추위가 심할 경우 손상될 수도 있는 취약한 지점이 있다.
    // 따라서 내부 공사 도중에도 외벽의 취약 지점들이 손상되지 않았는 지, 주기적으로 친구들을 보내서 점검
    // 점검 시간을 1시간으로 제한
    // 최소한의 친구들을 투입해 취약 지점을 점검하고 나머지 친구들은 내부 공사를 돕도록 하려고 한다.
    // 레스토랑의 정북 방향 지점을 0으로 나타낸다.

    static int[] Weak, Dist;
    static int[][] weak_cases;
    static boolean[] visited;
    static int[] output;


    static int N, answer;

    public int solution(int n, int[] weak, int[] dist) {
        weak_cases = new int[weak.length][weak.length];
        Weak = weak;
        Dist = dist;
        answer = Integer.MAX_VALUE;
        N = n;
        visited = new boolean[dist.length];
        output = new int[dist.length];

        makeWeakCases();
        permutation(0);
        if (answer == Integer.MAX_VALUE)
            return -1;
        else
            return answer;
    }

    private void permutation(int depth) {

        if (depth == Dist.length) {
            for (int[] weak_case : weak_cases) {
                check(weak_case);
            }

        } else {
            for (int i = 0; i < Dist.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    output[depth] = Dist[i];
                    permutation(depth + 1);
                    visited[i] = false;
                }
            }
        }

    }

    public static void main(String[] args) {
        외벽_점검 sol = new 외벽_점검();
        int result = sol.solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4});
        System.out.println(result);

    }

    void makeWeakCases() {
        int[] weak_case = this.Weak.clone(); // [1,5,6,10] -> [5,6,10,13]
        weak_cases[0] = weak_case.clone();
        for (int i = 1; i < Weak.length; i++) {
            int temp = weak_case[0]; // 1 -> 5 ->
            for (int j = 1; j < Weak.length; j++) {
                weak_case[j - 1] = weak_case[j]; // 5, 6, 10 -> 6, 10, 13
            }
            weak_case[Weak.length - 1] = temp + N; // 5, 6, 10, 13 \
            weak_cases[i] = weak_case.clone();
        }
    }

    void check(int[] weak_case) { // weak_case = [1,5,6,10] / output = [1,2,3,4]
        int cur = 0, next;
        int dist_idx = 0;
        while (cur < weak_case.length && dist_idx < Dist.length) {
            next = cur + 1; // 1 -> 2 -> 4
            while (next < weak_case.length &&
                    Math.abs(weak_case[cur] - weak_case[next]) <= output[dist_idx]) {
                next++; // 2 -> 3
            }
            cur = next; // 0 -> 1 -> 3 -> 4
            dist_idx++; // 0 -> 1 -> 2 -> 3
        }

        if (cur == weak_case.length && dist_idx < answer)
            answer = dist_idx;
    }


}
