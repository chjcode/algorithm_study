import java.io.*;
import java.util.*;

public class Main {
    // 꽃 한 송이를 표현할 클래스
    static class Flower {
        int cost;               // 꽃(5칸)의 비용 합
        List<int[]> positions;  // 꽃을 구성하는 좌표들 (5개)

        public Flower(int cost, List<int[]> positions) {
            this.cost = cost;
            this.positions = positions;
        }

        public int getCost() {
            return cost;
        }

        public List<int[]> getPositions() {
            return positions;
        }
    }

    static int N;
    static int[][] grid;

    // 두 꽃이 겹치는지(좌표 중복이 있는지) 확인하는 메서드
    private static boolean isOverlap(Flower f1, Flower f2) {
        for (int[] p1 : f1.getPositions()) {
            for (int[] p2 : f2.getPositions()) {
                if (p1[0] == p2[0] && p1[1] == p2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader와 StringTokenizer로 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가능한 꽃(5칸) 리스트
        List<Flower> flowers = new ArrayList<>();

        // 방향 (중심, 상, 하, 좌, 우)
        int[] dx = {0, -1, 1, 0, 0};
        int[] dy = {0, 0, 0, -1, 1};

        // 1) 가장자리 제외 (1부터 N-2까지)를 중심으로 꽃 객체 생성
        for (int x = 1; x < N - 1; x++) {
            for (int y = 1; y < N - 1; y++) {
                int cost = 0;
                List<int[]> pos = new ArrayList<>();
                boolean isValid = true;

                for (int d = 0; d < 5; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    // 격자 범위를 벗어나거나 이미 겹친다면 무효
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        isValid = false;
                        break;
                    }
                    cost += grid[nx][ny];
                    pos.add(new int[]{nx, ny});
                }

                if (isValid) {
                    flowers.add(new Flower(cost, pos));
                }
            }
        }

        // 2) 비용 기준으로 정렬 (필수가 아니지만 예시대로 정렬)
        flowers.sort(Comparator.comparingInt(Flower::getCost));

        int minCost = Integer.MAX_VALUE;
        int size = flowers.size();

        // 3) 꽃 3개를 고르는 모든 조합 탐색 (3중 루프)
        for (int i = 0; i < size - 2; i++) {
            Flower f1 = flowers.get(i);
            for (int j = i + 1; j < size - 1; j++) {
                Flower f2 = flowers.get(j);
                // f1과 f2가 겹치면 바로 continue
                if (isOverlap(f1, f2)) {
                    continue;
                }
                for (int k = j + 1; k < size; k++) {
                    Flower f3 = flowers.get(k);
                    // f1과 f3, f2와 f3가 겹치면 스킵
                    if (isOverlap(f1, f3) || isOverlap(f2, f3)) {
                        continue;
                    }
                    // 4) 세 송이의 비용 합 계산
                    int totalCost = f1.getCost() + f2.getCost() + f3.getCost();
                    // 5) 최소 비용 갱신
                    minCost = Math.min(minCost, totalCost);
                }
            }
        }

        // 결과 출력
        System.out.println(minCost);
    }
}
