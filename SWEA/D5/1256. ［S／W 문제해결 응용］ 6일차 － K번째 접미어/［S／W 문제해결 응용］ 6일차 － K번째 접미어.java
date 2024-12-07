import java.util.*;
import java.io.*;

public class Solution {
    static int k;
    static String s;
    static String[] arr;
    static String answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < t + 1; tc++) {

            k = Integer.parseInt(br.readLine());

            s = br.readLine();

            answer = " ";

            arr = new String[s.length()];
            for (int i = 0; i < s.length(); i++) {
                arr[i] = s.substring(i);
            }

            Arrays.sort(arr);

            answer = arr[k-1];

            System.out.println("#" + tc + " " + answer);




        }
    }
}
