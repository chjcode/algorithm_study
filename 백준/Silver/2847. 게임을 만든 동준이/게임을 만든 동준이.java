import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[] score = new int[n];

        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        
        for (int i = n - 2; i >= 0; i--) {
            if (score[i] >= score[i + 1]) {
                int newScore = score[i + 1] - 1;
                answer += (score[i] - newScore);
                score[i] = newScore;
            }
        }

        System.out.println(answer);
    }
}

