
import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[][] graph;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		graph = new int[n][n];
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				int temp = s.charAt(j) - '0';
				graph[i][j] = temp;
				if (temp == 1)
					flag = true;
			}
		}

		if (flag) {
			quadTree(0, 0, n);
		} else {
			sb.append(0);
		}

		System.out.println(sb.toString());

	}

	private static void quadTree(int startX, int startY, int size) {

		boolean flag = false;
		int firstNum = graph[startX][startY];
		for (int i = startX; i < startX + size; i++) {
			for (int j = startY; j < startY + size; j++) {
				if (graph[i][j] != firstNum) { // 처음 숫자랑 다르면 탈출
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}

		if (flag) {
			sb.append('(');
			quadTree(startX, startY, size / 2);
			quadTree(startX, startY + size / 2, size / 2);
			quadTree(startX + size / 2, startY, size / 2);
			quadTree(startX + size / 2, startY + size / 2, size / 2);
			sb.append(')');
		} else {
			sb.append(firstNum);
		}
	}
}
