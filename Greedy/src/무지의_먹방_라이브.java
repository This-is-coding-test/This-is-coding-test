import java.io.IOException;
import java.util.*;

public class 무지의_먹방_라이브 {

    static class Food {
        int idx;
        int time;

        public Food(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Food{" +
                    "idx=" + idx +
                    ", time=" + time +
                    '}';
        }
    }

    public int solution(int[] food_times, long k) {

        long food_sum = 0;
        for (int food_time : food_times) {
            food_sum += food_time;
        }

        if (food_sum <= k) return -1;

        PriorityQueue<Food> pQ = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
        for (int i = 0; i < food_times.length; i++) {
            pQ.offer(new Food(i+1, food_times[i]));
        }


        long total = 0;   // 먹기 위해 사용한 시간
        long prev = 0;  // 직전에 다 먹은 음식 시간
        long length = food_times.length;    // 남은 음식 개수

        while (k >= ((pQ.peek().time - prev) * length) + total) {
            int now = pQ.poll().time; // 1 -> 3
            total += (now - prev) * length; // 6 -> 16
            prev = now; // 1 -> 3
            length -= 1; // 5 -> 4

        }

        List<Food> foods = new ArrayList<>();
        while (!pQ.isEmpty()) {
            foods.add(pQ.poll());
        }

        foods.sort(Comparator.comparingInt(o -> o.idx));

        return foods.get((int) ((k - total) % length)).idx;
    }

    // 회전판에 먹어여 할 N개의 음식
    // 각 음식에는 1부터 N까지 번호
    // 각 음식을 섭취하는데 일정 시간이 소요된다.

    // 무지는 1번 음식부터 먹기 시작하며, 회전판은 번호가 증가하는 순서대로 무지 앞으로 가져다 놓는다.
    // 마지막 번호의 음식을 섭취한 후에는 회전판에 의해 다시 1번 음식이 무지 앞으로 온다.
    // 무지는 음식 하나를 1초 동안 섭취한 후 남은 음식은 그대로 두고, 다음 음식을 섭취한다.
    // 다음 음식이란, 아직 남은 음식 중 다음으로 섭취해야 할 가장 가까운 번호의 음식을 말한다.


    public static void main(String[] args) throws IOException {

        무지의_먹방_라이브 s = new 무지의_먹방_라이브();
        System.out.println(s.solution(new int[]{3, 3, 3}, 8));
        // 0~1초 -> 1번 음식 3 -> 2 [2,3,3]
        // 1~2초 -> 2번 음식 3 -> 2 [2,2,3]
        // 2~3초 -> 3번 음식 3 -> 2 [2,2,2]

        // 3~4초 -> 1번 음식 2 -> 1 [1,2,2]
        // 4~5초 -> 2번 음식 2 -> 1 [1,1,2]
        // 5~6초 -> 3번 음식 2 -> 1 [1,1,1]

        // 6~7초 -> 1번 음식 1 -> 0 [0,1,1]
        // 7~8초 -> 2번 음식 1 -> 0 [0,0,1]
        // 9초 -> 3

    }
}
