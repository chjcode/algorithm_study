import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());            
        }
        
        Arrays.sort(arr);
        
        long answer = 0;
        
        for (int i = 0; i < n-2; i++) {
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                
                if (sum == 0) {
                    // 모두 같은 숫자 일 때
                    if (arr[left] == arr[right]) {
                        int cnt = right - left + 1;
                        answer += (long) cnt * (cnt -1) / 2;
                        break;
                    } else {
                        // 다른 숫자일 때
                        int leftStack = arr[left];
                        int rightStack = arr[right];
                        int leftCnt = 1;
                        int rightCnt = 1;
                        // 왼쪽에 같은 숫자 몇 개 있는지 계산
                        while (left + 1 < right && arr[left + 1] == leftStack) {
                            left++;
                            leftCnt++;
                        }
                        // 오른쪽
                        while (right -1 > left && arr[right - 1] == rightStack) {
                            right--;
                            rightCnt++;
                        }
                        
                        left++;
                        right--;
                        answer += (long) leftCnt * rightCnt;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        System.out.println(answer);
    }
}