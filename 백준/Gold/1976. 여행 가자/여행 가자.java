import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		// 자기 자신을 부모로 갖도록 make set
		// 추후 입력되는 도시간의 연결 정보를 통해 각 노드는 자신의 루트 노드를 가리키게 된다.
		parent = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			parent[i] = i;
		}
		
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n+1; j++) {
				int num = Integer.parseInt(st.nextToken());
				//두 도시가 연결되어 있으면 union(부모 노드를 같게 만들기)
				if (num == 1) {
					union(i,j);
				}
			}
		}
		
		//입력 받고 첫 번째 도시의 루트 노드 확인
		st = new StringTokenizer(br.readLine());
		int start = find(Integer.parseInt(st.nextToken()));
		boolean flag = true;
		// 두 번째 도시부터 루트 노드를 찾았을 때 시작지점과의 루트노드가 다르면 연결된 도시가 아님
		for (int i = 1; i < m; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			if (start != find(now)) {
				System.out.println("NO");
				flag = false;
				break;
			}
		}
		
		if (flag) {
			System.out.println("YES");
		}
	}
	
	// 루트노드 찾는 find 메서드
	private static int find(int x) {
		// 이미 자기 자신이 루트노드이면 바로 return
		if (x == parent[x]) {
			return x;
		}
		
		// 자기 자신이 루트노드가 아니면 재귀를 통해서 루트노드 찾기
		parent[x] = find(parent[x]);
		
		// 찾은 루트 노드 반환
		return parent[x];
	}
	
	private static void union(int x, int y) {
		// x와 y의 루트노드를 각각 찾아서
		int xRoot = find(x);
		int yRoot = find(y);
		
		// 서로의 로트 노드가 다르다면 하나의 루트노드를 골라서 같게 해줌
		// 이렇게하면 루트노드가 같아지므로 부모가 같은 셈이 됨
		if (xRoot != yRoot) {
			parent[yRoot] = xRoot;
		}
	}
}
