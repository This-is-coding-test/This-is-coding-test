import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 왕실의_나이트 {

    static int[] dx = {-1, 1, -2, -2, -1, 1, 2, 2};
    static int[] dy = {-2, -2, -1, 1, 2, 2, -1, 1};

    static int[][] boards = new int[8][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        int x = st.charAt(0) - 97;
        int y = (st.charAt(1) - '0') - 1;

        int result = 0;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < 8 && ny < 8) {
                result++;
            }
        }
        System.out.println(result);


    }
}
