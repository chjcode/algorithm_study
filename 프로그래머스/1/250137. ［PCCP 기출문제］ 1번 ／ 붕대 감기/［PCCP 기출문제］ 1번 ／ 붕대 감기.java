import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int hp = health;
        int now = 0;
        
        for (int[] attack : attacks) {
            // 1. attack 당하기 전까지 붕대감기
            // attack 당하기 전까지 붕대 성공 횟수
            int success = (attack[0] - now) / bandage[0];
            // 붕대 연속 감은 횟수 저장
            answer = Math.max(answer, success);
            
            hp = hp + (attack[0] - now) * bandage[1] + success * bandage[2];
            
            now = attack[0]+1;
        
            // 최대 회복량은 health
            if (hp > health) hp = health;
            
            // 2. attack 적용
            hp -= attack[1];
            
            System.out.println(answer);
            
            // 3. 현재 Hp로 판별
            if (hp <= 0) {
                hp = -1;
                break;
            }
        }
        
        
        return hp;
    }
}

// 30 -> 2,10 _ 30 _ 20 -> 9,15 _ 30 _ 15 -> 10,5 _ 16 _ 11