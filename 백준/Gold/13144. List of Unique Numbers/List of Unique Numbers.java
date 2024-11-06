import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[] numbers;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		
		numbers = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Set<Integer> uniqueElements = new HashSet<>();
        int left = 0;
        long count = 0;

        for (int right = 0; right < numbers.length; right++) {
            while (uniqueElements.contains(numbers[right])) {
                uniqueElements.remove(numbers[left++]);
            }
            uniqueElements.add(numbers[right]);
            count += right - left + 1;
        }

        System.out.println(count);
		
	}

}
