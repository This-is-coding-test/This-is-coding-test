import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 문자열_재정렬 {

    static List<Character> characters = new ArrayList<>();
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                characters.add(c);
            } else {
                sum += c - '0';
            }
        }

        characters.sort(Comparator.comparingInt(o -> o));
        StringBuilder sb = new StringBuilder();

        for (Character character : characters) {
            sb.append(character);
        }
        if (sum != 0) {
            sb.append(sum);
        }

        System.out.println(sb);



    }
}
