import java.util.*;
import java.io.*;

public class Main {

    static class Log implements Comparable<Log>{
        int id;
        int score;
        int cnt;    //제출 횟수

        int time;

        Log (int id, int score, int cnt, int time) {
            this.id = id;
            this.score = score;
            this.cnt = cnt;
            this.time = time;
        }

        @Override
        public int compareTo(Log l) {
            if (this.score == l.score) {
                if (this.cnt == l.cnt) {
                    return Integer.compare(this.time,l.time);
                } else {
                    return Integer.compare(this.cnt, l.cnt);
                }
            } else {
                return Integer.compare(l.score, this.score);
            }
        }
    }

    static int n, k, t, m;
    static int[][] team;
    static int[] sum,count,time;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //풀이를 제출한 팀의 ID, 문제 번호, 점수가 서버의 록그에 제출되는시간

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());   // 팀 개수
            k = Integer.parseInt(st.nextToken());   // 문제 개수
            t = Integer.parseInt(st.nextToken());   // 우리 팀 id
            m = Integer.parseInt(st.nextToken());   // 로그 개수

            team = new int[n+1][k+1];    // 팀 문제별 점수
            sum = new int[n+1];
            count = new int[n+1];   // 팀 별 제출 횟수
            time = new int[n+1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                count[id]++;
                time[id] = i;
                if (team[id][num] < score) {
                    sum[id] -= team[id][num];
                    team[id][num] = score;
                    sum[id] += score;
                }
            }

            List<Log> logs = new ArrayList<>();
            for (int i = 1; i < n+1; i++) {
                logs.add(new Log(i, sum[i], count[i], time[i]));
            }

            Collections.sort(logs);

            int answer = 1;
            for (Log log : logs) {
                if (log.id == t) {
                    break;
                }
                answer++;
            }

            System.out.println(answer);
        }




    }
}
