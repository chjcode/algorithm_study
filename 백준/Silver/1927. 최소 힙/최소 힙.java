import java.util.*;
import java.io.*;

public class Main {

    static int n;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp > 0) {
                pq.add(temp);
            }else if (!pq.isEmpty()){
                System.out.println(pq.poll());
            } else{
                System.out.println(0);
            }

        }


    }

}
