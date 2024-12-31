import java.util.*;
import java.io.*;

public class Main {

    static String s, bomb;
    static int bLen;
    static ArrayList<Character> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        bomb = br.readLine();
        bLen = bomb.length();

        list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));

            if (list.size() >= bLen) {
                boolean flag = true;
                for (int j = 0; j < bLen; j++) {
                    if (list.get(list.size() - bLen + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < bLen; j++) {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (list.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for (char c : list) {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}
