import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        int[] dice = {a,b,c,d};
        for (int value : dice){
            map.put(value ,map.getOrDefault(value,0)+1);
        }
        
        if (map.size() == 1){
            //네 주사위가 같은 경우
            int p = a;
            return 1111 * p;
        } else if (map.size() == 2) {
            // 세 주사위 또는 두 주사위가 같은 경우
            int p = 0;
            int q = 0;
            for (int value : dice){
                if (value != p){
                    q = value;
                    break;
                }
            }
            
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                if (entry.getValue() == 3){
                    // 세 주사위가 같은 경우
                    p = entry.getKey();
                } else{
                    q = entry.getKey();
                }
            }
            if (map.containsValue(3)){
                return (10 * p + q) * (10 * p + q);
            } else{
                //두 주사위가 같은 경우   
                Iterator<Integer> iter = map.keySet().iterator();
                p = iter.next();
                q = iter.next();
                return (p + q) * Math.abs(p - q);
            }
            
        } else if (map.size() == 3) {
            int p = 0, q = 0, r = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                if (entry.getValue() == 2){
                    p = entry.getKey();
                } else if (q == 0){
                    q = entry.getKey();
                } else{
                    r = entry.getKey();
                }
            }
            return q*r;
        } else{
            int min = Integer.MAX_VALUE;
            for (int value : dice){
                if (value < min) {
                    min = value;
                }
            }
            return min;
        }
    }
}