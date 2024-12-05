import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr, record;
    static List<Integer> lis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        record = new int[n];
        lis = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int idx = Collections.binarySearch(lis,num);
            //lis에 binarySearch 때렸을 때 해당 숫자가 있으면 양수 idx
            // 없으면 음수값이 나오는데, 음수에 1더하고 - 때리면 해당 숫자가 들어갈 idx가 나옴
            if (idx < 0) {
                idx = -(idx + 1);
            }
            record[i] = idx;

            if (idx == lis.size()){
                lis.add(num);
            } else {
                lis.set(idx, num);
            }
        }

        // Lis 길이
        int lisLen = lis.size();
        sb.append(lisLen).append("\n");

        Deque<Integer> deq = new ArrayDeque<>();
        int currentIdx = lisLen - 1;
        for (int i = n - 1; i > -1; i--) {
            if (record[i] == currentIdx) {
                deq.addLast(arr[i]);
                currentIdx--;
                if (currentIdx < 0) break;  // 더 이상 추적할 값이 없음
            }
        }

        // 스택에서 꺼내서 LIS 출력
        while(!deq.isEmpty()) {
            sb.append(deq.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}
