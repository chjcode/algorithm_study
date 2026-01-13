import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int k = Integer.parseInt(br.readLine());
        int a = 1;
        int b = 0;
        for (int i = 0; i < k; i++) {
            int tempA = a;
            a = b;
            b += tempA;
        }
        
        System.out.println(a + " " + b);
    }
}
