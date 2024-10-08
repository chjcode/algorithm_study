import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[] arrN,arrM;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arrN = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i< m; i++) {
            int temp = Arrays.binarySearch(arrN,Integer.parseInt(st.nextToken()));
            if (temp >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
