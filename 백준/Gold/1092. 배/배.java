import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        
        Arrays.sort(crane, Collections.reverseOrder());
        box.sort(Collections.reverseOrder());
        
        if (box.get(0) > crane[0]) {
            System.out.println(-1);
            return;
        }
        
        int time = 0;
        while (!box.isEmpty()) {
            int idx = 0;
            for (int i = 0; i < n;) {
                if (idx == box.size()) break;
                if (crane[i] >= box.get(idx)) {
                    box.remove(idx);
                    i++;
                } else {
                    idx++;
                }
            }
            time++;
        }
        
        System.out.println(time);
    }
}