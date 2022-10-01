import java.io.IOException;
import java.util.*;

public class 실패율 {

    static class Stage {
        int idx;
        double rate;

        public Stage(int idx, double rate) {
            this.idx = idx;
            this.rate = rate;
        }

    }

    // 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수
    // N: 전체 스테이지 개수
    // stages: 게임을 이용하는 사용자가 현재 멈춰있는 스테이즈이 번호가 담긴 배열
    // 실패율이 높은 스테이지부터 내림차순으로 스테잊의 번호가 담겨 있는 배열을 return


    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages); // 1 2 2 2 3 3 4 6
        int total = stages.length; // 8
        List<Stage> stg = new ArrayList<>();

        int idx = 0;
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (; idx < stages.length; ) {
                if (stages[idx] == i) {
                    System.out.println(i);
                    cnt++;
                    System.out.println(cnt);

                    idx++;
                } else {
                    break;
                }
            }
            if (cnt != 0) {
                stg.add(new Stage(i, (double) cnt / total));
            } else {
                stg.add(new Stage(i, 0));
            }
            total -= cnt;
        }
        int[] answer = new int[N];
        stg.sort((o1, o2) -> Double.compare(o2.rate, o1.rate));
        for (int i = 0; i < N; i++) {
            answer[i] = stg.get(i).idx;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        실패율 s = new 실패율();
        s.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});


    }
}
