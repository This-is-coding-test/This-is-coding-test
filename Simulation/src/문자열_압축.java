import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열_압축 {
    public int solution(String s) {
        if (s.length() == 1) return 1;

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= s.length() / 2; i++) {

            StringBuilder newStr = new StringBuilder();
            String target = s.substring(0, i);
            int count = 1;
            for (int j = i; j < s.length(); j += i) {
                String post = "";
                if (j + i >= s.length()) {
                    post = s.substring(j);
                } else {
                    post = s.substring(j, j + i);
                }

                if (target.equals(post)) {
                    count++;
                } else {
                    if (count != 1) {
                        newStr.append(count).append(target);
                        count = 1;
                    } else {
                        newStr.append(target);
                    }
                    target = post;
                }
            }
            if (count != 1) {
                newStr.append(count).append(target);
            } else {
                newStr.append(target);
            }
            min = Math.min(min, newStr.length());

        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        문자열_압축 s = new 문자열_압축();
        System.out.println(s.solution("aabbaccc"));


    }
}
