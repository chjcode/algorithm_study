import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static Deque<Integer> deq;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 10;

        for (int t = 1; t <= T; t++) {
            // testcase 입력 받기
            int tc = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            // 암호 배열 입력 받기
            st = new StringTokenizer(br.readLine());
            deq = new ArrayDeque<>();

            for (int i = 0; i < 8; i++) {
                deq.addLast(Integer.parseInt(st.nextToken()));
            }

            check();

            System.out.print("#" + tc + " ");
            for (Integer value : deq) {
                System.out.print(value + " ");
            }
            System.out.println();

        }

    }
    private static void check(){
        while (true) {
            for (int i = 1; i < 6; i++){
                int temp = deq.pollFirst()-i;
                if (temp <= 0) {
                    deq.addLast(0);
                    return;
                } else {
                    deq.addLast(temp);
                }
            }
        }
    }
}
