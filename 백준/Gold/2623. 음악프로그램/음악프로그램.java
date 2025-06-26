import java.util.*;
import java.io.*;

public class Main {
    
    static int n,m;
    static List<List<Integer>> graph;
    static int[] inDegree;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());    //노드 수
        m = Integer.parseInt(st.nextToken());    // 간선 그룹 수
        
        graph = new ArrayList<>();    // 그래프
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        inDegree = new int[n+1];    // 진입 차수 배열
        
        // 간선 정보 받아서 그래프 만들기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int[] order = new int[cnt];    // 가수 순서 저장
            
            for (int j = 0; j < cnt; j++) {
                order[j] = Integer.parseInt(st.nextToken());
            }
            
            for (int j = 0; j < cnt - 1; j++) {
                int u = order[j];
                int v = order[j+1];
                graph.get(u).add(v);
                inDegree[v]++;    // u의 진입 차수 증가
            }
        }
        
        // 위상 정렬 시작
        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 1; i < n+1; i++) {
            if (inDegree[i] == 0) {
                deq.addLast(i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        while(!deq.isEmpty()) {
            int now = deq.pollFirst();
            result.add(now);
            
            for (int next : graph.get(now)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    deq.add(next);
                }
            }
        }
        
        // 결과 출력
        if (result.size() != n) {
            System.out.println(0);
        } else {
            for (int r : result) {
                System.out.println(r);
            }
        }
    }
}