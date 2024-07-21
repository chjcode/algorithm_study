
import java.util.*;
import java.io.*;

public class Main {

    public static class Jewel implements Comparable<Jewel>{
        int weight;
        int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel j) {
            return this.weight - j.weight;
        }
    }
    static int n,k;
    static long totalValue;
    static int[] bags;
    static Jewel[] jewels;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        jewels = new Jewel[n];
        bags = new int[k];
        //보석 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        // 가방 입력
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        // 오름차순 정렬
        Arrays.sort(bags);
        Arrays.sort(jewels);    //무슨 기준으로 정렬이되는거지?

        // 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int jewelIdx = 0;

        for (int i = 0; i < k; i++) {
            while (jewelIdx < n) {
                if (bags[i] < jewels[jewelIdx].weight) {
                    break;
                }
                pq.add(jewels[jewelIdx].value);
                jewelIdx++;
            }

            if (!pq.isEmpty()) {
                totalValue += pq.poll();
            }
        }
        System.out.println(totalValue);
    }
}

/**
 * 1. 용량이 적은 가방에 들어가지 못한 보석이 용량이 큰 가방에 들어갈 수 있다.
 * 그러나 용량이 큰 가방에 들어가지 못한 보석이 용량이 적은 가방에 들어갈 수는 없다.
 * 따라서 용량이 작은 가방부터 채워나가면 최선의 결과를 얻을 수 있음이 보장된다.
 */


/**
 * 1. 보석가격으로 정렬
 * 2. 2중 for문 돌면서 보석 무게보다 큰 가방을 찾아서 들어감
 * 3. 들어갈 때 마다 cnt += 1하면서 가방이랑 값이 똑같아지면 break
 */