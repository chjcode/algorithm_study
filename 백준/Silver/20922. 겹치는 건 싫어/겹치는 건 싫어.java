import java.util.*;
import java.io.*;

public class Main {
    static int n,k,max,cnt,left,right;
    static int[] graph, visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //도현이를 위해 같은 원소가 k개 이하로 들어있는
        //최장 연속 부분 수열의 길이
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new int[200001];
        graph = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            graph[i] = num;
        }

        max = 1;
        cnt = 0;
        left = 0;
        right = 0;
        // n 이 1일 수도 있음을 고려
        while (right < n) {
            int lNum = graph[left];
            int rNum = graph[right];
//            System.out.print(rNum + " -> " );
            if (visited[rNum]+1 <= k) {
                visited[rNum] += 1;
                right++;
                cnt++;
//                System.out.println(cnt + "visited[rNum] : " + visited[rNum]);
//                System.out.println("right: " + right + ", left : " + left);
            } else {
                visited[lNum] -= 1;
                left++;
                cnt--;
//                System.out.println(cnt + "visited[lNum] : " + visited[lNum]);
//                System.out.println("left: " + left + ", right : " + right);
            }
            max = Math.max(max,cnt);
        }

        System.out.println(max);
    }
}
