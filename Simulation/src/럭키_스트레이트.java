import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 럭키_스트레이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();
        int mid = st.length() / 2;

        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < mid; i++) {

            sumA += st.charAt(i) - '0';
            sumB += st.charAt(i + mid) - '0';

        }

        System.out.println(sumA == sumB ? "LUCKY" : "READY");


    }
}
