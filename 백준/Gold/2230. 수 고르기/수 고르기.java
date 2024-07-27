
import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static long m,answer;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());

        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        answer = Long.MAX_VALUE;
//        for (int i = 0; i < n-1; i++) {
//            for (int j = i+1; j < n; j++) {
//                long sub = Math.abs(arr[i] - arr[j]);
//                if (m <= sub) {
//                    answer = Math.min(answer, sub);
//                }
//            }
//        }
        Arrays.sort(arr);
        int left = 0;
        int right = 1;

        while (right < n){
            long lNum = arr[left];
            long rNum = arr[right];
            long sub = rNum - lNum;
            if (sub < m) {
                right++;
            } else if (sub > m){
                answer = Math.min(answer,sub);
                left++;
                if (left == right) right++;
            } else{
                answer = sub;
                break;
            }
        }

        System.out.println(answer);
    }
}
