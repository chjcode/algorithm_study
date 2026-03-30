import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        //철수 영희 카드 절반씩
        // 가장 큰 양의 정수 a
        // 철수 카드는 다 나누면서 영희 카드는 하나도 못 나누는 a
        // 영희 카드는 다 나누면서 철수 카드는 하나도 못 나누는 a
        
        int gdcA = arrayA[0];
        for (int i = 0;i < arrayA.length; i++) {
            gdcA = gdc(gdcA, arrayA[i]);
        }
        
        int gdcB = arrayB[0];
        for (int i = 0;i < arrayB.length; i++) {
            gdcB = gdc(gdcB, arrayB[i]);
        }
        
        boolean flagA = true;
        for (int num : arrayB) {
            if (num % gdcA == 0) {
                flagA = false;
                break;
            }
        }
        
        boolean flagB = true;
        for (int num : arrayA) {
            if (num % gdcB == 0) {
                flagB = false;
                break;
            }
        }
        
        if (flagA) answer = Math.max(answer, gdcA);
        if (flagB) answer = Math.max(answer, gdcB);
        
        return answer;
    }
    
    private int gdc(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}