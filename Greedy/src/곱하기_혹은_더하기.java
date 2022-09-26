import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱하기_혹은_더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        int[] arr = new int[st.length()];

        for (int i = 0; i < st.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(st.charAt(i)));
        }

        int result = 0;

        for (int i = 0; i < st.length(); i++) {
            if (result <= 1 || arr[i] <= 1) {
                result += arr[i]; // 2
            } else {
                result *= arr[i]; // 2 * 9 -> 18 * 8 ->
            }
        }

        System.out.println(result);


    }
}
