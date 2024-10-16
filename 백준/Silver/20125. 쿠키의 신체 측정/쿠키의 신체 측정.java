
import java.util.*;
import java.io.*;
public class Main {

	static int n, headX,headY, bodyEndX, bodyEndY;
	static char[][] graph;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		graph = new char[n][n];
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				char temp = s.charAt(j);
				graph[i][j] = temp;
				if (!flag && temp =='*') {
					headX = i;
					headY = j;
					flag = true;
				}
			}
		}
		
		
		// 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리
		// 가슴에서 탐색 시작
		// 왼쪽
		int leftArmX = headX+1;
		int leftArmY = headY;
		int leftArmCnt = 0;
		while (true) {
			int nx = leftArmX;
			int ny = leftArmY-1;
			if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) break;
			if (graph[nx][ny] == '*') {
				leftArmCnt++;
				leftArmX = nx;
				leftArmY = ny;
			} else {
				break;
			}
		}
		
		int rightArmX = headX+1;
		int rightArmY = headY;
		int rightArmCnt = 0;
		while (true) {
			int nx = rightArmX;
			int ny = rightArmY+1;
			if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) break;
			if (graph[nx][ny] == '*') {
				rightArmCnt++;
				rightArmX = nx;
				rightArmY = ny;
			} else {
				break;
			}
		}
		
		int bodyX = headX+1;
		int bodyY = headY;
		int bodyCnt = 0;
		while (true) {
			int nx = bodyX+1;
			int ny = bodyY;
			if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) break;
			if (graph[nx][ny] == '*') {
				bodyCnt++;
				bodyX = nx;
				bodyY = ny;
			} else {
				bodyEndX = nx-1;
				bodyEndY = ny;
				break;
			}
		}
		
		int leftLegX = bodyEndX+1;
		int leftLegY = bodyEndY-1;
		int leftLegCnt = 1;
		while (true) {
			int nx = leftLegX+1;
			int ny = leftLegY;
			if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) break;
			if (graph[nx][ny] == '*') {
				leftLegCnt++;
				leftLegX = nx;
				leftLegY = ny;
			} else {
				break;
			}
		}
		
		int rightLegX = bodyEndX+1;
		int rightLegY = bodyEndY+1;
		int rightLegCnt = 1;
		while (true) {
			int nx = rightLegX+1;
			int ny = rightLegY;
			if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) break;
			if (graph[nx][ny] == '*') {
				rightLegCnt++;
				rightLegX = nx;
				rightLegY = ny;
			} else {
				break;
			}
		}
		System.out.println((headX+1+1) + " " + (headY+1));
		System.out.println(leftArmCnt + " " + rightArmCnt + " " + bodyCnt + " " +  leftLegCnt + " " + rightLegCnt);
	}

}
