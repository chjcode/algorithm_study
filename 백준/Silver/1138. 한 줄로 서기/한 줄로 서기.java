import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        answer = new int[n];
        Arrays.fill(answer,-1);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int taller = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                if (answer[j] == -1) {
                    if (taller == 0) {
                        answer[j] = i + 1;
                        break;
                    }
                    taller--;
                }
            }
        }

        for (int i = 0 ; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
