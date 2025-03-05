import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        int[] numbers = new int[10];
        for (int i = 0; i < X.length(); i++) {
            int num = X.charAt(i) - '0';
            numbers[num]++;
        }
        
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < Y.length(); i++) {
            int num = Y.charAt(i) - '0';
            if (numbers[num] > 0) {
                lst.add(num);
                numbers[num]--;
            }
        }
        
        if (lst.size() == 0) return "-1";
        
        StringBuilder sb = new StringBuilder();
        Collections.sort(lst, Collections.reverseOrder());
        for (int l : lst) {
            sb.append(l);
        }
        
        if (sb.toString().charAt(0) == '0') return "0";
        
        return sb.toString();
    }
}