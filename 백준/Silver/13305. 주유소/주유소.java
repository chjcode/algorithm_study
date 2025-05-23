import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static long answer;

    static long[] len, cost;


    public static void main(String args[]) throws Exception {
        //1. 출발할 때는 다음 주유소까지 필요한 만큼 기름 넣기
        //2. 다음 주유소에 도착했는데 이전 주유소가 더싸면 이전 주유소(stack)
        // 에서 다음 주유소까지 기름 넣기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        len = new long[n-1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            len[i] = Long.parseLong(st.nextToken());
        }
        cost = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long stack = cost[0];
        answer = stack * len[0];
        for (int i = 1; i < n-1; i++) {
            if (cost[i] < stack) {
                stack = cost[i];
            }
            answer += stack * len[i];
        }

        System.out.println(answer);
    }
}