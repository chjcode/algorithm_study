
import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[] graph;
	static Set<Integer> order;
	static List<Integer> orderLst;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		graph = new int[n];
		order = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			graph[i] = temp;
			order.add(temp);
		}
		
		orderLst = new ArrayList<>(order);
		Collections.sort(orderLst);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(binarySearch(graph[i])).append(" ");
		}

		System.out.println(sb.toString());
	}

	private static int binarySearch(int num) {
		int left = 0;
		int right = orderLst.size();

		while (left < right) {
			int mid = (left + right) / 2;
			if (orderLst.get(mid) < num) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left;
	}

}
