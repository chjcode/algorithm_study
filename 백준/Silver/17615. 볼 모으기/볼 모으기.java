import java.util.*;
import java.io.*;
public class Main {

    static int n, cnt, answer;
    static char[] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        graph = new char[n];

        for (int i = 0; i < n; i++) {
            char color = s.charAt(i);
            graph[i] = color;
        }

        answer =  Integer.MAX_VALUE;

        cnt = 0;
        // 뒤에서부터 연속되지 않는 빨간색 개수, 파란색 개수 세기
        boolean flag = false;
        for (int i = n-1; i > -1; i--) {
            if (graph[i] == 'B') {
                flag = true;
            } else if (graph[i] == 'R' && flag) {
                cnt++;
            }
        }
        answer = Math.min(answer, cnt);

        // 뒤에서부터 연속되지 않는 파란색 개수 세기
        flag = false;
        cnt = 0;
        for (int i = n-1; i > -1; i--) {
            if (graph[i] == 'R') {
                flag = true;
            } else if (graph[i] == 'B' && flag) {
                cnt++;
            }
        }
        answer = Math.min(answer, cnt);

        cnt = 0;
        flag = false;
        for (int i = 0; i < n; i++) {
            if (graph[i] == 'B') {
                flag = true;
            } else if (graph[i] == 'R' && flag) {
                cnt++;
            }
        }
        answer = Math.min(answer, cnt);

        cnt = 0;
        flag = false;
        for (int i = 0; i < n; i++) {
            if (graph[i] == 'R') {
                flag = true;
            } else if (graph[i] == 'B' && flag) {
                cnt++;
            }
        }
        answer = Math.min(answer, cnt);

        System.out.println(answer);

    }
}
