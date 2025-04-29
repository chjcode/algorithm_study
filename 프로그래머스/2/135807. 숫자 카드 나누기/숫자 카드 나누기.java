import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        
        int answer = 0;
        int n = arrayA.length;
        
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for (int i = 1; i < n; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }
        
        for (int i = 1; i < n; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        boolean flag = true;
        for(int num : arrayB) {
            if (num % gcdA == 0) {
                flag = false;
                break;
            }
        }
        
        if (flag) {
            answer = Math.max(answer, gcdA);
        }
        
        flag = true;
        for(int num : arrayA) {
            if (num % gcdB == 0) {
                flag = false;
                break;
            }
        }
        
        if (flag) {
            answer = Math.max(answer, gcdB);
        }
        
    
        return answer;
    }
    
    private int gcd (int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}