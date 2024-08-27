
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m,d,answer;
	static int[][] graph;
	static Point[] archer;
	
	static class Point{
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 0~m mC3 구해서 임의의 좌표 (n+1,j)에 궁수 배치
		// 각 궁수랑 가장 가까운 적 0으로 바꾸기 , cnt += 1
		// 적 전체 한 칸 내리기
		// 좌표 밖으로 넘어간 애들은 그냥 버림
		
		//1. 궁수 배치
		answer = 0;
		archer = new Point[3];
		combination(0,0);
		
		System.out.println(answer);
	}
	
	private static void combination(int start, int cnt) {
		
		if (cnt == 3) {
			play();
			return;
		}
		
		for (int j = start; j < m; j++) {
			archer[cnt] = new Point(n,j);
			combination(j+1,cnt+1);
		}
	}
	
	private static void play() {
		// 각 궁수랑 가장 가까운 적 0으로 바꾸고 cnt +=1
		// 전체 적 한 칸 내리기
		// 게임이 끝날 때 까지 반복
		
		int cnt = 0;
		
		int[][] tempGraph = new int[n][m];
        for (int i = 0; i < n; i++) {
            tempGraph[i] = graph[i].clone();
        }
		
		while (true) {
			boolean flag = false;
			int[] minLen = new int[3];
			Point[] minEnemy = new Point[3];
			Arrays.fill(minLen, Integer.MAX_VALUE);
			// 궁수랑 가장 가까운 적 찾기
			for (int i = 0; i < n; i++) {
				for (int j = 0 ; j < m; j++) {
					if (tempGraph[i][j] == 1) {
						flag = true;
						for (int k = 0; k < 3; k++) {
							int len = Math.abs(i-archer[k].x) + Math.abs(j-archer[k].y);
							if (len <= d) {
								if (len < minLen[k]) {
									minLen[k] = len;
									minEnemy[k] = new Point(i,j);
								}else if (len == minLen[k] && j < minEnemy[k].y) {
									minEnemy[k] = new Point(i,j);
								}
							}
						}
					}
				}
			}
			
			if (flag) {	// 적이 있으면
				// 궁수랑 가장 가까운 적 0으로 바꾸고 cnt += 1
				for (int i = 0; i < 3; i++) {
					if (minEnemy[i] != null) {
						if (tempGraph[minEnemy[i].x][minEnemy[i].y] == 1) {
                            tempGraph[minEnemy[i].x][minEnemy[i].y] = 0;
                            cnt++;
                        }
					}
				}
				
				// 전체 적 한 칸 내리기
				for (int i = n-1; i > 0; i--) {
					tempGraph[i] = tempGraph[i-1].clone();
				}
				Arrays.fill(tempGraph[0], 0);

			}else {		//적이 없으면 return;
				answer = Math.max(answer, cnt);
				return;
			}	
		}
	}	
}
