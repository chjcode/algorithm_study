class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        StringBuilder result = new StringBuilder();
        
        int lenO = overwrite_string.length();
        int lenM = my_string.length();
        
        for (int i = 0; i < s;i++){
            result.append(my_string.charAt(i));
        }
        
        for (int i = 0; i < lenO;i++){
            result.append(overwrite_string.charAt(i));
        }
        
        for (int i = lenO+s;i<lenM;i++){
            result.append(my_string.charAt(i));
        }
        
        return result.toString();
    }
}