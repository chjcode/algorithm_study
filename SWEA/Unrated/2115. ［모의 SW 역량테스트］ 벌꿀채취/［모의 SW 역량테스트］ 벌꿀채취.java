
import java.util.*;
import java.io.*;

public class Solution {
	
	static int n,m,c,answer;
	static int[][] graph;
	static int[] a,b;
	static List<Point> lst;
	
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
		
		int t = Integer.parseInt(br.readLine());
		// 가로로 연속되도록 m개의 벌통 선택
		for (int tc = 1; tc < t+1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());	// 꿀을 채취할 수 있는 벌통의 수
			c = Integer.parseInt(st.nextToken());	// 채취할 수 있는 최대 벌꿀 양
			
			graph = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = 0;
			lst = new ArrayList<>();
			// 1. 벌통 선택 - 시작점을 기준으로
			combination(0,0);
			
			System.out.println("#" + tc + " " + answer);
		}
		
		
	}
	
	// graph를 1차원으로 생각하고 combination
	private static void combination(int start, int cnt) {
		if (cnt == 2) {
			chooseHoney();
//			for (int i = 0; i < 2; i++) {
//				System.out.print(lst.get(i).x + "," + lst.get(i).y + " ");
//			}
//			System.out.println();
			return;
		}
		
		for (int i = start; i < n*n; i++) {
			int row = i/n;
			int col = i%n;
		
			if (col > n-m) {	// 연속된 벌통을 선택할 수 없는 좌표는 선택 x
				continue;
			}
			// 선택된 좌표가 이전 좌표와 중복되는지 확인
			boolean flag = false;
			for (Point point : lst) {
//				for (int a = point.y; a < point.y+m;a++) {
//					if (point.x == row && a == col) {	// 중복이면
//						flag = true;
//						break;
//					}
//				}
				if (point.x == i / n && (Math.abs(point.y - (i % n)) < m)) { // 같은 행에서 겹치는지 확인
					flag = true;
					break;
				}
				if (flag) break;
			}
			if (flag) continue;
			lst.add(new Point(row, col));
			combination(i+1, cnt+1);
			lst.remove(lst.size()-1);
		}
	}
	
	// 부분집합으로 최적의 꿀 선택
	private static void chooseHoney() {
		int total = 0;
		for (int h = 0; h < 2; h++) {
			int[] honey = new int[m];
			for (int i = 0; i < m; i++) {
				honey[i] = graph[lst.get(h).x][lst.get(h).y+i];

			}

			
			int maxHoney = 0;
			for (int i = 0; i < (1<<m); i++) {
				int sum = 0;
				int profit = 0;
				for (int j = 0 ; j < (1<<m); j++) {
					if ((i & (1<<j)) != 0) {
						// 각 자릿수에 맞는 꿀 비교
						sum += honey[j];
						profit += honey[j] * honey[j];
					}
				}
				if (sum <= c) {
					maxHoney = Math.max(maxHoney, profit);
				}
			}
			total += maxHoney;
		}
		answer = Math.max(answer, total);
	}

}


//10
//4 2 13
//6 1 9 7
//9 8 5 8
//3 4 5 3
//8 2 6 7
