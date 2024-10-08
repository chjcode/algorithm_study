
import java.util.*;
import java.io.*;

public class Main {

    static int n,x;
    static int[] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int cntDay = 1;
        for (int i = 0; i < x; i++) {
            max+= graph[i];
        }

        int cnt = max;
        for (int i = 0; i < n-x; i++) {
            cnt = cnt-graph[i] + graph[i+x];

            if (cnt > max) {
                max = cnt;
                cntDay = 1;
            } else if (cnt == max) {
                cntDay += 1;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cntDay);
        }
    }


}
