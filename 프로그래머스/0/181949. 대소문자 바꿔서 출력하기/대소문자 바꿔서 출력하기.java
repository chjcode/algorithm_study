import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
    	StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < a.length();i++){
            char temp = a.charAt(i);
            if(Character.isLowerCase(temp)){
                answer.append(Character.toUpperCase(temp));
            } else {
                answer.append(Character.toLowerCase(temp));
            }
        }
        System.out.println(answer.toString());
    }
}