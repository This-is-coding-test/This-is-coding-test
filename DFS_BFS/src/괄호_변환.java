import java.io.IOException;
import java.util.Stack;

public class 괄호_변환 {

    // 소스코드에 작성된 모든 괄호를 뽑아서 올바른 순서대로 배치된 괄호 문자열을 알려주는 프로그램

    // '(', ')' 개수가 같다면 균형잡힌 괄호 문자열
    // '(', ')' 괄호의 짝도 모두 맞을 경우에는 이를 올바른 괄호 문자열
    // 균형잡힌 문자열인 경우
    // 1. 입력이 빈 문자열의 경우, 빈 문자열을 반환
    // 2. 문자열 w를 두 '균형잡힌 문자열' u, v로 분리 / 단, u는 '균형잡힌 문자열'로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있다.
    // 3.  문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행한다.
    // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.

    // 4. 문자열 u가 '올바른 괄호 문자열'이 아니라면 아래 과정을 수행
    // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙인다.
    // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙인다.
    // 4-3. ')'를 다시 붙인다.
    // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙인다.
    // 4-5 생성된 문자열을 반환

    static int pos;

    public String solution(String p) {
        if (p.isEmpty()) return p;

        boolean correct = isCorrect(p); // true, false
        String u = p.substring(0, pos);
        String v = p.substring(pos);

        if (correct) {
            return u + solution(v);
        }

        String answer = "(" + solution(v) + ")";

        for (int i = 1; i < u.length() - 1; i++) {

            if (u.charAt(i) == ')') {
                answer += '(';
            } else {
                answer += ')';
            }
        }
        return answer;
    }

    private boolean isCorrect(String p) {

        boolean check = true;
        int left = 0;
        int right = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(') {
                left++;
                stack.push('(');
            } else {
                right++;

                if (stack.isEmpty()) {
                    check = false;
                } else {
                    stack.pop();
                }
            }

            if (left == right) {
                pos = i + 1;
                return check;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        괄호_변환 s = new 괄호_변환();
        System.out.println(s.solution(")("));


    }
}
