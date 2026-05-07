import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        Set<Character> skipSet = new HashSet<>();

        for (int i = 0; i < skip.length(); i++) {
            skipSet.add(skip.charAt(i));
        }

        List<Character> alphabet = new ArrayList<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!skipSet.contains(ch)) {
                alphabet.add(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int pos = alphabet.indexOf(current);

            int nextPos = (pos + index) % alphabet.size();
            result.append(alphabet.get(nextPos));
        }

        return result.toString();
    }
}