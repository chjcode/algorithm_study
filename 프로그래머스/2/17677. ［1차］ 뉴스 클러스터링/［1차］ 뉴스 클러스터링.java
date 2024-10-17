import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        double answer = 0;
        
        // 1. 문자열 두 글자씩 끊어서 다중집합 만들기
        // 2. 두 글자씩 끊을 때 공백이나 특수문자가 들어있으면 버리기
        // 3. 문자열 유사도 구하기 -> set에 전체 다 집어넣고  (전체 다중집합 길이 - set 길이) / set 길이
        
        // 투 포인터로 두 글자씩 
        List<String> lst1 = new ArrayList<>();
        List<String> lst2 = new ArrayList<>();
        
        for (int i = 0; i < str1.length()-1; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i+1);
            
            if (Character.isLetter(a) && Character.isLetter(b)) {
                String s = (""+a+b).toLowerCase();
                lst1.add(s);
            }
            
        }
        
        for (int i = 0; i < str2.length()-1; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i+1);
            
            if (Character.isLetter(a) && Character.isLetter(b)) {
                String s = (""+a+b).toLowerCase();
                lst2.add(s);
            }
        }
        
        
        if (lst1.size() == 0 && lst2.size() == 0) {
            answer = 65536;
        } else{
            
            List<String> intersection = new ArrayList<>();
            List<String> union = new ArrayList<>();
            
            for (String s: lst1) {
                if (lst2.remove(s)) {
                    intersection.add(s);
                }
                
                union.add(s);
            }
            
            for (String s: lst2) {
                union.add(s);
            }
            
            answer = (double)intersection.size() / union.size() * 65536;
            
        }
        
        
        return (int)answer;
    }
}