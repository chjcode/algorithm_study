import java.util.*;
import java.io.*;

public class Main {
    
    static class Node {
        int score;
        Node red;
        Node blue;
        boolean isOccupied;
        
        Node(int score) {
            this.score = score;
        }
        
    }
    
    static final int TURN = 10;
    static int[] dice = new int[TURN];
    static Node[] horses = new Node[4];
    static int max = 0;
    static Node end;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < TURN; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }
        
        Node[] nodes = new Node[43];
        Node start = new Node(0);
        nodes[0] = start;
        Node prev = start;
       
        for (int i = 2; i <= 40; i+=2) {
            nodes[i] = new Node(i);
            prev.red = nodes[i];
            prev = prev.red;
        }
        
        end = new Node(0);
        
        Node n25 = new Node(25);
        Node n30 = new Node(30);
        Node n35 = new Node(35);
        Node n40 = nodes[40];

        n25.red = n30;
        n30.red = n35;
        n35.red = n40;
        n40.red = end;
        
        Node n13 = new Node(13);
        Node n16 = new Node(16);
        Node n19 = new Node(19);
        nodes[10].blue = n13;
        n13.red = n16;
        n16.red = n19;
        n19.red = n25;

        Node n22 = new Node(22);
        Node n24 = new Node(24);
        nodes[20].blue = n22;
        n22.red = n24;
        n24.red = n25;

        Node n28 = new Node(28);
        Node n27 = new Node(27);
        Node n26 = new Node(26);
        nodes[30].blue = n28;
        n28.red = n27;
        n27.red = n26;
        n26.red = n25;

        for (int i = 0; i < 4; i++) {
            horses[i] = start;
        }
        
        dfs(0,0);
        System.out.println(max);  
    }
    
    static void dfs(int turn, int totalScore) {
        if (turn == TURN) {
            max = Math.max(max, totalScore);
            return;
        }

        for (int i = 0; i < 4; i++) {
            Node cur = horses[i];
            if (cur == end) continue;

            Node next = move(cur, dice[turn]);
            if (next != end && next.isOccupied) continue;

            Node prev = horses[i];
            horses[i] = next;

            if (prev != end) prev.isOccupied = false;
            if (next != end) next.isOccupied = true;

            dfs(turn + 1, totalScore + (next == end ? 0 : next.score));

            horses[i] = prev;
            if (prev != end) prev.isOccupied = true;
            if (next != end) next.isOccupied = false;
        }
    }

    static Node move(Node node, int step) {
        Node cur = node;
        if (cur.blue != null) {
            cur = cur.blue;
            step--;
        } else {
            cur = cur.red;
            step--;
        }

        while (step-- > 0 && cur != null) {
            cur = cur.red;
        }

        return cur == null ? end : cur;
    }
}