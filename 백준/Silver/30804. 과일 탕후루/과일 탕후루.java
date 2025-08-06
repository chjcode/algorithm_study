import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] tang = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tang[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        while (right < n) {
            int rightFruit = tang[right];
            map.put(rightFruit, map.getOrDefault(rightFruit, 0) + 1);
            right++;
            
            while(map.size() > 2) {
                int leftFruit = tang[left];
                map.put(leftFruit, map.get(leftFruit) - 1);
                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left);
            
        }
        
        System.out.println(maxLen);
    }
}