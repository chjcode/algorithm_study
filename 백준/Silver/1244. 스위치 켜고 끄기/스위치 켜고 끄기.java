import java.util.*;
import java.io.*;

public class Main {

    static int switchNum, studentNum;
    static int[] graph;

    static class Student{
        int sex;
        int num;
        Student(int sex, int num) {
            this.sex = sex;
            this.num = num;
        }
    }


    public static void main(String args[]) throws Exception{
        /**
         * 남학생 : 스위치 번호가 자기가 받은 수의 배수이면 스위치 상태 바꿈
         * 여학생 : 받은 수 와 같은 번호  3이면 2,4 또는 1,5 이런식으로
         * 좌우 대칭이면서 가장 많은 스위치를 포함하는 구간 찾아서 그 구간에 속한
         * 스위치 모두 바꾸기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        switchNum = Integer.parseInt(br.readLine());
        graph = new int[switchNum];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < switchNum; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        studentNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (sex == 1) {
                boy(num);
            } else {
                girl(num);
            }
        }

        for (int i = 0; i < switchNum; i++) {
            System.out.print(graph[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
        if (switchNum % 20 != 0) {
            System.out.println();
        }
    }

    private static void boy(int num) {
        for (int i = num - 1; i < switchNum; i += num) {
            graph[i] = 1 - graph[i];
        }
    }

    private static void girl(int num) {
        int index = num - 1;
        int left = index;
        int right = index;

        while (left > 0 && right < switchNum - 1 && graph[left - 1] == graph[right + 1]) {
            left--;
            right++;
        }

        for (int i = left; i <= right; i++) {
            graph[i] = 1 - graph[i];
        }
    }

}