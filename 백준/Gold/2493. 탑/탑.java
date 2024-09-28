import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static Top[] graph;
    static Deque<Top> stack;
    static class Top {
        int height;
        int idx;

        Top(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        graph = new Top[n];
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            graph[i] = new Top(temp,i);
        }
        StringBuilder sb = new StringBuilder();
        stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()){
                if (stack.peekLast().height > graph[i].height) {
                    sb.append(stack.peekLast().idx+1).append(" ");
                    break;
                }
                stack.pollLast();
            }
            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            }
            stack.addLast(graph[i]);
        }
        System.out.println(sb.toString().trim());
    }
}
