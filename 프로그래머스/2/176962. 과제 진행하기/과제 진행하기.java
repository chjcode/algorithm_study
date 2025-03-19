import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        int n = plans.length;
        List<String> answer = new ArrayList<>();
        
        // 새로운 과제를 시작할 시각이 되었을 때, 진행중이던 과제 멈추고 새로운 과제 시작
        // 둘 다 있으면 새로 시작해야하는 과제 부터 진행
        // 스택
        
        Arrays.sort(plans, (a,b) -> change(a[1]) - change(b[1]));
        
        int currentTime = change(plans[0][1]);
        
        Stack<String[]> stack = new Stack<>();
        for (String[] plan : plans) {
            String name = plan[0];
            int start = change(plan[1]);
            int playtime = Integer.parseInt(plan[2]);
            
            while (!stack.isEmpty()) {
                String[] last = stack.pop();
                int homework = Integer.parseInt(last[2]);
                int available = start - currentTime;
                
                if (homework <= available) {
                    currentTime += homework;
                    answer.add(last[0]);
                } else {
                    homework -= available;
                    currentTime = start;
                    last[2] = String.valueOf(homework);
                    stack.push(last);
                    break;
                }
            }
            
            if (currentTime < start) {
                currentTime = start;
            }
            
            stack.push(new String[]{name, plan[1], plan[2]});
        }
        
        while (!stack.isEmpty()) {
            answer.add(stack.pop()[0]);
        }
        
        return answer.toArray(new String[0]);
    }
    
    private int change(String time) {
        String[] temp = time.split(":");
        int h = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        return h * 60 + m;
    }
}