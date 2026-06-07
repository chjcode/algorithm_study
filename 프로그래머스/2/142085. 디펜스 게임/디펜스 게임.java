import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int soldier = n;

        for (int i = 0; i < enemy.length; i++) {
            soldier -= enemy[i];
            pq.offer(enemy[i]);

            if (soldier < 0) {
                if (k == 0) {
                    return i;
                }

                soldier += pq.poll();
                k--;
            }
        }

        return enemy.length;
    }
}