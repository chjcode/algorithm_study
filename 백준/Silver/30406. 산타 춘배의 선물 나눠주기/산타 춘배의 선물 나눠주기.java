import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] cnt = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            cnt[num]++;
        }
        
        //for (int i = 0; i < 4; i++) {
        //    for (int j = 0; j < 4; j++) {
        //        int temp = i^j;
        //        System.out.println(i + ", " + j + " : " + temp);
        //    }
        //}
        
        int answer = 0;
        
        int temp = Math.min(cnt[0], cnt[3]);
        cnt[0] -= temp;
        cnt[3] -= temp;
        answer += temp*3;
        
        temp = Math.min(cnt[1], cnt[2]);
        cnt[1] -= temp;
        cnt[2] -= temp;
        answer += temp*3;
        
        temp = Math.min(cnt[0], cnt[2]);
        cnt[0] -= temp; cnt[2] -= temp;
        answer += temp * 2;

        temp = Math.min(cnt[1], cnt[3]);
        cnt[1] -= temp; cnt[3] -= temp;
        answer += temp * 2;
        
        temp = Math.min(cnt[0], cnt[1]);
        cnt[0] -= temp; cnt[1] -= temp;
        answer += temp;

        temp = Math.min(cnt[2], cnt[3]);
        cnt[2] -= temp; cnt[3] -= temp;
        answer += temp;
        
        System.out.println(answer);
    }
}


/**
0, 0 : 0
0, 1 : 1
0, 2 : 2
0, 3 : 3
1, 0 : 1
1, 1 : 0
1, 2 : 3
1, 3 : 2
2, 0 : 2
2, 1 : 3
2, 2 : 0
2, 3 : 1
3, 0 : 3
3, 1 : 2
3, 2 : 1
3, 3 : 0
**/