
import java.util.*;
import java.io.*;

public class Main {

    static int n,a,b;
    static List<Integer> answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();
        // a-1개 삽입
        for (int i = 1; i < a; i++) {
            answer.add(i);
        }

        answer.add(Math.max(a,b));

        // b-1개 삽입
        for (int i = b - 1; i > 0; i--) {
            answer.add(i);
        }

        StringBuilder sb = new StringBuilder();
        if (answer.size() > n) {
            sb.append(-1);
        } else{
            sb.append(answer.get(0)).append(" ");
            for (int i = 0; i < n - answer.size(); i++) {
                sb.append(1).append(" ");
            }
            for (int i = 1; i < answer.size(); i++) {
                sb.append(answer.get(i)).append(" ");
            }
        }

        System.out.println(sb.toString());

    }
}
