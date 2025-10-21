class Solution {

    
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int bShort = Math.min(bill[0], bill[1]);
        int bLong = Math.max(bill[0], bill[1]);
        int wShort = Math.min(wallet[0], wallet[1]);
        int wLong = Math.max(wallet[0], wallet[1]);
        
        while (bShort > wShort || bLong > wLong) {
            bLong /= 2;
            // bShort이 더 길어지면 bLong에 bShort 집어넣어야함
            if (bShort > bLong) {
                int temp = bLong;
                bLong = bShort;
                bShort = temp;
            }
            answer++;
        }
        
        
        return answer;
    }

}