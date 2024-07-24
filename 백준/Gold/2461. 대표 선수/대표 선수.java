
import java.util.*;
import java.io.*;

public class Main {

    static int n,m,minIdx,answer;
    static int[][] students;
    static int[] index;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        students = new int[n][m];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                students[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // students 정렬
        for (int i = 0; i < n; i++){
            Arrays.sort(students[i]);
        }

        index = new int[n];
        answer = Integer.MAX_VALUE;
        minIdx = 0;
        while (true) {
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                //최댓값 찾기
                if (students[i][index[i]] > max) {
                    max = students[i][index[i]];
                }
                //최솟값 찾기
                if (students[i][index[i]] < min) {
                    min = students[i][index[i]];
                    minIdx = i; // 최솟값 index 저장
                }
            }
            answer = Math.min(answer, max-min);
            index[minIdx] += 1; // 제일 작은 값 index 갱신
            if (index[minIdx] == m){    // 마지막 인덱스를 만나면 break
                break;
            }
        }
        System.out.println(answer);
    }
}
