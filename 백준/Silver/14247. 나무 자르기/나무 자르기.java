import java.util.*;
import java.io.*;

public class Main {
    
    static class Tree implements Comparable<Tree> {
        int height;
        int grow;
        Tree (int height, int grow) {
            this.height = height;
            this.grow = grow;
        }
        
        @Override
        public int compareTo(Tree t) {
            return Integer.compare(this.grow, t.grow);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[] tree = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] grow = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            grow[i] = Integer.parseInt(st.nextToken());
        }
        
        Tree[] trees = new Tree[n];
        for (int i = 0; i < n; i++) {
            trees[i] = new Tree(tree[i], grow[i]);
        }
        
        Arrays.sort(trees);
        
        
        long answer = 0;
        for(int i = 0; i < n; i++) {
            answer += trees[i].height + (long)i * trees[i].grow;
        }
        
        System.out.println(answer);
    }
}