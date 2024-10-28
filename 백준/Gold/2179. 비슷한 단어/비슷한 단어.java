/*
Welcome to JDoodle!

You can execute code here in 88 languages. Right now you’re in the Java IDE.

  1. Click the orange Execute button ▶ to execute the sample code below and see how it works.

  2. Want help writing or debugging code? Type a query into JDroid on the right hand side ---------------->

  3.Try the menu buttons on the left. Save your file, share code with friends and open saved projects.

Want to change languages? Try the search bar up the top.
*/

import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    static String[] graph;
    static int[][] visited;
    
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        graph = new String[n];
        for (int i = 0; i < n; i++) {
            graph[i] = br.readLine();
        }
        
        
        String temp1 = "";
        String temp2 = "";
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < Math.min(graph[i].length(), graph[j].length()); k++) {
                    if (graph[i].charAt(k) == graph[j].charAt(k)) {
                        cnt++;
                    } else {
                        break;
                    }
                }
                
                if (max < cnt) {
                    temp1 = graph[i];
                    temp2 = graph[j];
                    max = cnt;
                }
            }
        }
        
        System.out.println(temp1);
        System.out.println(temp2);
    }
}