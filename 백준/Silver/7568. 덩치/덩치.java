import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static Student[] student;

    static class Student {
        int w;
        int h;

        Student(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        student = new Student[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            student[i] = new Student(w,t);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int idx = 1;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (student[i].w < student[j].w && student[i].h < student[j].h) {
                    idx++;
                }
            }

            sb.append(idx).append(" ");
        }

        System.out.println(sb);

    }
}
