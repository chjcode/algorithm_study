
import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static Map<Integer,Integer> map, mapSum;
    static int[] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            graph = new int[n];
            map = new HashMap<>();
            st = new StringTokenizer(br.readLine());

            // 각 팀의 출전 횟수를 기록
            for (int i = 0; i < n; i++) {
                int temp = Integer.parseInt(st.nextToken());
                map.put(temp, map.getOrDefault(temp, 0) + 1);
                graph[i] = temp;
            }

            mapSum = new HashMap<>();
            Map<Integer, Integer> tmpMap = new HashMap<>();
            int[] fifthPlayer = new int[1001]; // 최대 팀 번호는 1000 이하
            int score = 1;

            // 점수 계산 및 5번째 선수 기록
            for (int i = 0; i < n; i++) {
                int team = graph[i];
                if (map.get(team) == 6) {  // 팀원이 6명인 팀만 계산
                    tmpMap.put(team, tmpMap.getOrDefault(team, 0) + 1);

                    // 4명까지만 점수를 기록
                    if (tmpMap.get(team) <= 4) {
                        mapSum.put(team, mapSum.getOrDefault(team, 0) + score);
                    }

                    // 5번째 선수의 점수 기록
                    if (tmpMap.get(team) == 5) {
                        fifthPlayer[team] = score;
                    }

                    score++;
                }
            }

            // 우승팀 찾기
            int result = Integer.MAX_VALUE;
            int fifthScore = Integer.MAX_VALUE;
            int winningTeam = 0;

            for (Integer key : mapSum.keySet()) {
                int tmp = mapSum.get(key);
                if (tmp < result) {  // 점수가 낮은 팀 우승
                    result = tmp;
                    fifthScore = fifthPlayer[key];
                    winningTeam = key;
                } else if (tmp == result) {  // 점수가 같으면 5번째 선수 점수 비교
                    if (fifthScore > fifthPlayer[key]) {
                        winningTeam = key;
                    }
                }
            }

            // 우승팀 출력
            System.out.println(winningTeam);
        }
    }
}
