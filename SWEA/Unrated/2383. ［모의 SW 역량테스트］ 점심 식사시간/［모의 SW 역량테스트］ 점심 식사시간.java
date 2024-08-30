import java.io.*;
import java.util.*;

public class Solution {

    static int n;
    static int[][] graph;
    static List<Person> persons;
    static List<Stair> stairs;

    static class Person {
        int x;
        int y;
        int dist = 0;

        Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Stair {
        int x;
        int y;
        int time;

        Stair(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            graph = new int[n][n];
            persons = new ArrayList<>();
            stairs = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) {
                        persons.add(new Person(i, j));
                    } else if (num > 1) {
                        stairs.add(new Stair(i, j, num));
                    }
                }
            }

            int minTime = Integer.MAX_VALUE;
            // 비트 마스킹을 사용해서 사람들이 계단을 선택하는 모든 부분집합을 구함
            for (int i = 0; i < (1 << persons.size()); i++) {
                int[] dist = new int[persons.size()];    // 사람과 계단 사이 거리 구한 배열
                for (int j = 0; j < persons.size(); j++) {
                    Person p = persons.get(j);
                    if ((i & (1 << j)) == 0) {
                        dist[j] = Math.abs(p.x - stairs.get(0).x) + Math.abs(p.y - stairs.get(0).y);
                    } else {
                        dist[j] = Math.abs(p.x - stairs.get(1).x) + Math.abs(p.y - stairs.get(1).y);
                    }
                }

                int time = simulate(dist, i);
                minTime = Math.min(minTime, time);
            }

            System.out.printf("#%d %d\n", tc, minTime);
        }
    }

    // 모든 사람이 계단을 내려가는데 걸리는 시간 시뮬 돌리며 계산
    static int simulate(int[] dist, int selection) {
        int finish = 0;        // 모든 사람이 계단을 다 내려갔는지를 확인하기 위한 변수, 비트마스킹 사용
        int time = 0;        // 소요 시간
        int people = dist.length;    //사람 수

        // 모든 사람이 계단을 다 내려갈 때까지 반복
        while (finish != (1 << people) - 1) {
            int[] newDist = new int[people];    //시간에 따른 상태 갱신
            boolean[] waiting = new boolean[people];    // 계단 도착했지만 내려가는 중이 아닌 사람

            for (int i = 0; i < people; i++) {
                if ((finish & (1 << i)) != 0) continue;

                if (dist[i] > 0) {
                    newDist[i] = dist[i] - 1;
                } else if (dist[i] == 0) {
                    waiting[i] = true;
                } else {
                    newDist[i] = dist[i] + 1;
                    if (newDist[i] == 0) finish |= 1 << i;
                }
            }

            for (int i = 0; i < people; i++) {
                if (!waiting[i]) continue;
                boolean group = (selection & (1 << i)) == 0;
                int cnt = 0;

                for (int j = 0; j < people; j++) {
                    if (group == ((selection & (1 << j)) == 0) && newDist[j] < 0) cnt++;
                }

                if (cnt < 3) newDist[i] = -1 * stairs.get(group ? 0 : 1).time;
            }

            time++;
            dist = newDist;
        }

        return time;
    }
}
