import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static boolean[] alpha;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        alpha = new boolean[26];

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            List<String> lst = new ArrayList<>();
            while (st.hasMoreTokens()) {
                lst.add(st.nextToken());
            }

            StringBuilder sb = new StringBuilder();
            boolean flag = false;   // 단어별 첫 글자가 단축키 지정 되었는지 여부 판단
//            for (int j = 0; j < lst.size(); j++) {
//                boolean isFirstLowerCase = Character.isLowerCase(lst.get(j).charAt(0));
//                if (!flag && isFirstLowerCase) {
//                    if (!alpha[lst.get(j).charAt(0) - 97]) {
//                        //단축키 지정 안되었으면
//                        alpha[lst.get(j).charAt(0)-97] = true;
//                        // [] 대괄호 붙여주기
//                        flag = true;
//                        sb.append("[")
//                                .append(lst.get(j).charAt(0))
//                                .append("]")
//                                .append(lst.get(j).substring(1,lst.get(j).length()))
//                                .append(" ");
//                    }
//                } else if (!flag && !isFirstLowerCase){
//                    if (!alpha[lst.get(j).charAt(0) - 65]) {
//                        alpha[lst.get(j).charAt(0) - 65] = true;
//                        flag = true;
//                        sb.append("[")
//                                .append(lst.get(j).charAt(0))
//                                .append("]")
//                                .append(lst.get(j).substring(1,lst.get(j).length()))
//                                .append(" ");
//                    }
//                } else {
//                    sb.append(lst.get(j)).append(" ");
//                }
//            }

            // 첫 글자가 단축키로 지정 안되었으면 모두 탐색
//            if (!flag) {
//                for (String s : lst) {
//
//                }
//            }
            for (int j = 0; j < lst.size(); j++) {
                String word = lst.get(j);
                char first = word.charAt(0);
                if (!flag) {
                    // 대소문자 구분하여 인덱스 계산
                    int idx = -1;
                    if (Character.isLowerCase(first)) {
                        idx = first - 'a';
                    } else if (Character.isUpperCase(first)) {
                        idx = first - 'A';
                    }

                    // 해당 알파벳이 아직 사용되지 않았다면 단축키 지정
                    if (idx != -1 && !alpha[idx]) {
                        alpha[idx] = true;
                        flag = true;
                        sb.append("[")
                                .append(first)
                                .append("]")
                                .append(word.substring(1))
                                .append(" ");
                    } else {
                        sb.append(word).append(" ");
                    }
                } else {
                    sb.append(word).append(" ");
                }
            }

            if (!flag) {
                sb.setLength(0);

                for (int j = 0; j < lst.size(); j++) {
                    String word = lst.get(j);
                    boolean used = false;

                    for (int k = 0; k < word.length(); k++) {
                        char c = word.charAt(k);

                        if (!Character.isLetter(c)) continue;

                        int idx;
                        if (Character.isLowerCase(c)) {
                            idx = c - 'a';
                        } else {
                            idx = c - 'A';
                        }

                        if (!alpha[idx]) {
                            alpha[idx] = true;
                            flag = true;
                            used = true;

                            sb.append(word, 0, k)
                                    .append("[")
                                    .append(c)
                                    .append("]")
                                    .append(word.substring(k + 1))
                                    .append(" ");
                            break;
                        }
                    }

                    if (!used) {
                        sb.append(word).append(" ");
                    }

                    if (flag) {
                        j++;
                        while (j < lst.size()) {
                            sb.append(lst.get(j++)).append(" ");
                        }
                        break;
                    }
                }
            }

            System.out.println(sb.toString().trim());
        }

    }

}
