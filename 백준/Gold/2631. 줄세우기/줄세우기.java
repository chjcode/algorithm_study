import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		List<Integer> lst = new ArrayList<>();
		for (int num : arr) {
			int idx = Collections.binarySearch(lst, num);
			if (idx < 0) {
				idx = -(idx + 1);
			}
			if (idx == lst.size()) {
				lst.add(num);
			} else {
				lst.set(idx, num);
			}
		}
		
		int result = n-lst.size();
		System.out.println(result);
	}

}
