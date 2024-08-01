
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Student implements Comparable<Student> {

        long score;
        int idx;

        Student(long score, int idx) {
            this.score = score;
            this.idx = idx;
        }


        @Override
        public int compareTo(Student s) {
            return (int) (s.score-this.score);
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0","C-","D0"};


        for (int tc = 1; tc < t+1; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            List<Student> lst = new ArrayList<>();

            
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long score = a*35 + b*45 + c*20;
                lst.add(new Student(score, i));
            }

            Collections.sort(lst);

            for (int i = 0; i < n; i++){
                if (lst.get(i).idx == k-1) {
                    System.out.println("#" + tc + " " + grade[i/(n/10)]);
                    break;
                }
            }

        }
    }
}
