import java.io.*;
import java.util.*;

public class Main {

    static int n,k;
    static int[] belt;
    static boolean[] robot;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        belt = new int[2*n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
        robot = new boolean[n];

        int step = 0;
        while (true) {
            step++;

            // 벨트 회전
            int temp = belt[n*2-1];
            for (int i = n * 2 - 1; i > 0; i--) {
                belt[i] = belt[i-1];
            }
            belt[0] = temp;

            // 로봇 회전
            for (int i = n - 1; i > 0; i--) {
                robot[i] = robot[i-1];
            }
            robot[0] = false;
            robot[n-1] = false;

            // 로봇 이동
            for (int i = n - 1; i > 0; i--) {
                //현재 로봇이 있고, 다음 칸에 로봇이 없고, 내구도가 0보다 크면
                // 로봇을 내리고 내구도 1 감소
                if (robot[i - 1] && !robot[i] && belt[i] > 0) {
                    robot[i-1] = false;
                    robot[i] = true;
                    robot[n-1] = false;
                    belt[i]--;
                }
            }

            // 내구도가 0보다 크면 로봇 올리고 내구도 1 감소
            if (belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
            }


            // 전체 내구도 확인
            int cnt = 0;
            for (int i = 0; i < n * 2; i++) {
                if (belt[i] == 0) {
                    cnt++;
                }
            }

            if (cnt >= k) {
                break;
            }

        }
        System.out.println(step);
    }
}
