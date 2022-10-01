import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 국영수 {
    static class Student {

        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }


    }
    static int N;
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students.add(new Student(name, kor, eng, math));
        }

        Collections.sort(students, (o1, o2) -> {
            if (o1.kor == o2.kor && o1.eng == o2.eng && o1.math == o2.math) {
                return o1.name.compareTo(o2.name);
            }
            else if (o1.kor == o2.kor && o1.eng == o2.eng) {
                return o2.math - o1.math;
            }else if (o1.kor == o2.kor) {
                return o1.eng - o2.eng;
            }
            return o2.kor - o1.kor;
        });

        for (Student student : students) {
            System.out.println(student.name);
        }

    }
}
