import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int count0 = 0; // 0 -> 1
        int count1 = 0; // 1 -> 0

        // 첫 번째 원소에 대해 처리
        if (str.charAt(0) == '0') {
            count1++;
        } else {
            count0++;
        }

        // 0 -> 1
        for (int i = 0; i < str.length() - 1; i++) {

            if (str.charAt(i) != str.charAt(i + 1)) {
                if (str.charAt(i + 1) == '1') { // 0 -> 1
                    count0++;
                } else { // 1 -> 0
                    count1++;
                }
            }
        }

        System.out.println(Math.min(count0, count1));

    }
}
