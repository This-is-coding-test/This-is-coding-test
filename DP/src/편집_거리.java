import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 편집_거리 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st1 = br.readLine(); // 6
        String st2 = br.readLine(); // 8

        dp = new int[st2.length() + 1][st1.length() + 1];

        for (int i = 0; i <= st1.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= st2.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= st2.length(); i++) {

            for (int j = 1; j <= st1.length(); j++) {
                if (st2.charAt(i - 1) == st1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                    dp[i][j] += 1;
                }
            }
        }


        System.out.println(dp[st2.length()][st1.length()]);


    }
}
