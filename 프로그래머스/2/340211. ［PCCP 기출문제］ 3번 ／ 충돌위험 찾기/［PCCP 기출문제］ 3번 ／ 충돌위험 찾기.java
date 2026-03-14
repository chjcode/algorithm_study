import java.util.*;

class Solution {

    public int solution(int[][] points, int[][] routes) {
        List<List<String>> robotMoves = new ArrayList<>();
        int maxTime = 0;

        for (int[] route : routes) {
            List<String> move = new ArrayList<>();

            int startIdx = route[0] - 1;
            int nowR = points[startIdx][0];
            int nowC = points[startIdx][1];
            move.add(nowR + "," + nowC);

            for (int i = 1; i < route.length; i++) {
                int nextIdx = route[i] - 1;
                int targetR = points[nextIdx][0];
                int targetC = points[nextIdx][1];

                while (nowR != targetR) {
                    if (nowR < targetR) nowR++;
                    else nowR--;
                    move.add(nowR + "," + nowC);
                }

                while (nowC != targetC) {
                    if (nowC < targetC) nowC++;
                    else nowC--;
                    move.add(nowR + "," + nowC);
                }
            }

            robotMoves.add(move);
            maxTime = Math.max(maxTime, move.size());
        }

        int answer = 0;

        for (int t = 0; t < maxTime; t++) {
            Map<String, Integer> countMap = new HashMap<>();

            for (List<String> move : robotMoves) {
                if (t < move.size()) {
                    String pos = move.get(t);
                    countMap.put(pos, countMap.getOrDefault(pos, 0) + 1);
                }
            }

            for (int count : countMap.values()) {
                if (count >= 2) {
                    answer++;
                }
            }
        }

        return answer;
    }
}