class Solution {
    public String solution(String code) {
        String answer = "";
        
        boolean mode = false;
        
        for (int i = 0; i < code.length();i++){
            if (!mode){
                if (code.charAt(i) != '1'){
                    if (i % 2 == 0){
                        answer += code.charAt(i);
                    }
                } else {
                    mode = true;
                }
            } else {
                if (code.charAt(i) != '1'){
                    if (i % 2 == 1){
                        answer += code.charAt(i);
                    }
                } else {
                    mode = false;
                }
            }
        }
        
        if (answer.equals("")){
            answer = "EMPTY";
        }
        
        return answer;
    }
}