import java.util.*;
import java.io.*;

public class Main {

    static int l,w,h,n,answer;
    static int[] cube;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        n = Integer.parseInt(br.readLine());
        cube = new int[20]; // 크기별 큐브의 개수 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            // cube[크기] = 개수;
            cube[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        answer= 0;
        flag = false;
        find(l,w,h);

        if (!flag) {
            answer = -1;
        }
        System.out.println(answer);
    }

    private static void find(int length, int width, int height) {
        // 상자의 길이, 너비, 높이 중 하나라도 0이면 더 이상 넣을 수 없으므로 리턴
        if (length == 0 || width == 0 || height == 0) {
            return;
        }

        int edge = 0;   // 큐브의 변 길이
        flag = false;   // 큐브 채울 수  있는지 여부 초기화

        // 큰 큐브 부터 채워 넣기
        for (int i = 19; i > -1; i--) {
            edge = 1<<i;    // 2^i (큐브의 변 길이)

            // 상자에 큐브를 넣을 수 있고, 큐브 개수가 남아있다면
            if (edge <= length && edge <= width && edge <= height && cube[i] > 0) {
                cube[i]--;
                answer++;
                flag = true;

                find(length-edge, edge, edge);
                find(length,width-edge, edge);
                find(length,width,height-edge);

                break;  // 큐브 채우면 for문 탈출
            }
        }
    }

}
