import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] graph;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 스타트 팀 / 링크 팀 -> 두 팀 인원수 달라도 됨(최소 1 이상)
        // 두 팀의 능력치 차이를 최소 출력
        // 1, 2, 3 같은 팀 -> 12, 13, 21, 23, 31
        // 1,2,3으로 나올 수 있는 경우의 수 체크
        
        // 팀 구하기
        // 팀 점수 확인
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //비트마스킹으로 모든 경우의 수 찾기
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < (1<<n) - 1; i++) {
            // 팀 구하기
            List<Integer> startTeam = new ArrayList<>();
            List<Integer> linkTeam = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    startTeam.add(j);
                } else {
                    linkTeam.add(j);
                }
            }
            
            // 팀 점수 확인
            int startCnt = cal(startTeam);
            int linkCnt = cal(linkTeam);
            answer = Math.min(answer, Math.abs(startCnt-linkCnt));
        }
        
        System.out.println(answer);
    }
    
    private static int cal(List<Integer> team) {
        int cnt = 0;
        int size = team.size();
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                int a = team.get(i);
                int b = team.get(j);
                cnt += graph[a][b] + graph[b][a];
            }
        }
        
        return cnt;
    }
}