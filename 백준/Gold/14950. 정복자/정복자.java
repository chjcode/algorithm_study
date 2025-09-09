import java.io.*;
import java.util.*;

public class Main {
    
    static class Node implements Comparable<Node> {
        int u, v, w;
        Node(int u, int v, int w){
            this.u=u;
            this.v=v;
            this.w=w;
        }
        public int compareTo(Node n){
            return Integer.compare(this.w, n.w);
        }
    }
    
    static int[] parent, rank;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());

        List<Node> nodes = new ArrayList<>(m);
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes.add(new Node(a,b,c));
        }
        Collections.sort(nodes);

        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=1;i<=n;i++) parent[i]=i;

        long mst = 0;
        int picked = 0;
        for(Node nd : nodes){
            if(union(nd.u, nd.v)){
                mst += nd.w;
                if(++picked == n-1) break;
            }
        }

        long extra = t * (long)(n-1) * (n-2) / 2;
        System.out.println(mst + extra);
    }
    
    private static int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    private static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a==b) return false;
        
        if(rank[a] < rank[b]) { 
            int tmp=a; a=b; b=tmp; 
        }
        parent[b]=a;
        
        if(rank[a]==rank[b]) rank[a]++;
        
        return true;
    }
}
