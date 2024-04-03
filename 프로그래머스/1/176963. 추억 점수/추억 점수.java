// import java.util.*;

// class Solution {
//     public int[] solution(String[] name, int[] yearning, String[][] photo) {
//         int[] answer = new int[photo.length];
        
//         Map<String,Integer> map = new HashMap<>();
        
//         for (int i=0;i<name.length;i++){
//             map.put(name[i],yearning[i]);
//         }
        
//         for (int i=0;i<photo.length;i++){
//             int cnt = 0;
//             for (int j=0;j<photo[i].length;j++){
//                 if (map.containsKey(photo[i][j]))
//                     cnt += map.get(photo[i][j]);
//             }
//             answer[i] = cnt;
//         }
        
//         return answer;
//     }
// }

import java.util.*;

class Solution{
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        int[] result = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if (map.containsKey(photo[i][j])){
                    score += map.get(photo[i][j]);
                }
            }
            result[i] = score;
        }
        return result;
    }
}