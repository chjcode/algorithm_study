class Solution {
    public int solution(int[] arr) {
        
        int num1 = arr[0];
        for (int i = 1; i < arr.length; i++) {
            num1 = num1 * arr[i] / cal(num1, arr[i]);
        }
        
        
        return num1;
    }
    
    // 유클리드 호제법
    // A = qB + r 일 때
    // gcd(A,B) = gcd(B,r) 이다.
    
    private int cal(int num1, int num2) {
        if (num2 == 0) return num1;
        return cal(num2, num1%num2);
    }
}