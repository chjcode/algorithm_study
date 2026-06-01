import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String calling : callings) {
            int idx = map.get(calling);
            
            map.put(players[idx], idx-1);
            map.put(players[idx-1], idx);
            
            String temp = players[idx-1];
            players[idx-1] = players[idx];
            players[idx] = temp;
        }
        
        

        
        return players;
    }
}



// import java.util.*;

// class Solution {
//     public String[] solution(String[] players, String[] callings) {
        
//         // Map 만들기
//         Map<String, Integer> map = new HashMap<>();
//         // Map에 players 정보 저장
//         for (int i=0;i<players.length;i++){
//             map.put(players[i], i);
//         }
//         // 선수들 위치 바꾸기
//         for (String calling : callings){
//             int idx = map.get(calling);  // 현재 순위
            
//             String temp = players[idx-1];   // 이전 index 선수 이름
//             players[idx-1] = calling;
//             players[idx] = temp;
            
//             map.put(calling, idx-1);
//             map.put(temp, idx);
//         }
        
//         return players;
//     }
// }