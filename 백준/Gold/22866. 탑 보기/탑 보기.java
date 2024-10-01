import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static Building[] buildings;
    static int[] count, near;
    static Deque<Building> deq;

    static class Building{
        int height;
        int idx;
        Building (int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        buildings = new Building[n+1];
        count = new int[n+1];
        near = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            buildings[i] = new Building(Integer.parseInt(st.nextToken()), i);
            near[i] = Integer.MAX_VALUE;
        }

        deq = new ArrayDeque<>();
        for (int i = 1; i < n+1; i++) {
            while(!deq.isEmpty() && deq.peekLast().height <= buildings[i].height) {
                deq.pollLast();
            }

            int temp = deq.size();
            count[i] = temp;
            if (temp > 0) {
                near[i] = deq.peekLast().idx;
            }
            deq.addLast(buildings[i]);
        }

        deq = new ArrayDeque<>();
        for (int i = n; i > 0; i--) {
            while(!deq.isEmpty() && deq.peekLast().height <= buildings[i].height) {
                deq.pollLast();
            }

            int temp = deq.size();
            count[i] += temp;
            if (temp > 0 && Math.abs(deq.peekLast().idx-i) < Math.abs(i-near[i])) {
                near[i] = deq.peekLast().idx;
            }
            deq.addLast(buildings[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            sb.append(count[i]);
            if (count[i] > 0) {
                sb.append(" ").append(near[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
