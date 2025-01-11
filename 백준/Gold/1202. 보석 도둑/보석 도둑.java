import java.util.*;
import java.io.*;

public class Main {
    static int n,k,c;
    static Jewel[] jewels;
    static int[] bags;

    static class Jewel{
        int m;  //무게
        int v;  //가격

        Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        jewels = new Jewel[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewels[i] = new Jewel(m,v);
        }

        bags = new int[k];
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, (j1, j2) -> Integer.compare(j1.m, j2.m));
        Arrays.sort(bags);

        PriorityQueue<Jewel> pq = new PriorityQueue<>((j1, j2) -> Integer.compare(j2.v, j1.v));

        // 적은 무게를 담을 수 있는 가방부터 탐색 시작
        int jewelsIdx = 0;
        long answer = 0;
        for (int i = 0; i < k; i++) {
            while (jewelsIdx < n) {
                if (bags[i] >= jewels[jewelsIdx].m) {
                    pq.add(jewels[jewelsIdx]);
                    jewelsIdx++;
                } else {
                    break;
                }
            }

            if (!pq.isEmpty()) {
                answer += pq.poll().v;
            }
        }

        System.out.println(answer);
    }
}
