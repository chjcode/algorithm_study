import java.util.*;

class Solution {
    public int solution(String name) {
        final int n = name.length();
        int answer = 0;          // 최종 이동 횟수

        /* 1) ▲▼ : 알파벳(세로) 이동 비용 */
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        /* 2) ◀▶ : 커서(가로) 이동 비용
              - 기본 : 맨 끝까지 오른쪽으로만 이동 → n‑1
              - 연속된 'A' 구간을 앞·뒤로 우회해 더 짧게 갈 수 있는지 확인
        */
        int move = n - 1;                    // 기본값
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            // i 뒤쪽으로 이어지는 연속 'A' 구간 찾기
            while (next < n && name.charAt(next) == 'A') next++;

            /* ① 오른쪽 → 왼쪽으로 꺾기 : i*2 + (n-next)
               ② 왼쪽 → 오른쪽으로 꺾기 : (n-next)*2 + i
               두 패턴 모두 비교해 최소값 유지 */
            move = Math.min(move, i * 2 + n - next);
            move = Math.min(move, (n - next) * 2 + i);
        }

        return answer + move;
    }
}
