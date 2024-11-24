
import java.util.*;
import java.io.*;

public class Main {

    static int n,m,answer;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int temp = Integer.parseInt(st.nextToken());
        answer = temp;
        int stack = temp;
        for (int i = 1; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            if ((x-stack) % 2 == 0) {
                answer = Math.max(answer, (x-stack)/2);
            } else {
                answer = Math.max(answer, (x-stack)/2+1);
            }
            stack = x;
        }

        answer = Math.max(answer,n-stack);

        System.out.println(answer);

    }
}