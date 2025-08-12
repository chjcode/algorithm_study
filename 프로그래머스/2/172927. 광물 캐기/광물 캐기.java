import java.util.*;

class Solution {
    
    static enum Mat {
        DIA, FE, ROCK
    }
    
    static class Block {
        int d;
        int i;
        int s;
        int cnt;
        
        Block (int d, int i, int s) {
            this.d = d;
            this.i = i;
            this.s = s;
            this.cnt = d*25 + i * 5 + s;
        }
    }
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int pickCnt = picks[0] + picks[1] + picks[2];
        int mine = Math.min(minerals.length, pickCnt * 5);
        
        List<Block> blocks = new ArrayList<>();
        for (int idx = 0; idx < mine; idx+=5) {
            int d = 0;
            int i = 0;
            int s = 0;
            
            for (int k = idx; k < Math.min(idx+5, mine); k++) {
                if (minerals[k].equals("diamond")) d++;
                else if (minerals[k].equals("iron")) i++;
                else if (minerals[k].equals("stone")) s++;
            }
            
            blocks.add(new Block(d,i,s));
        }

        //난이도가 높은 블록부터 좋은 곡갱이 배정
        blocks.sort((a,b) -> Integer.compare(b.cnt,a.cnt));
        
        for (Block b : blocks) {
            if (picks[0] > 0) {
                picks[0]--;
                answer += (b.d + b.i + b.s);
            } else if (picks[1] > 0) {
                picks[1]--;
                answer += (b.d * 5) + b.i + b.s;
            } else if (picks[2] > 0) {
                picks[2]--;
                answer += (b.d * 25) + (b.i * 5) + b.s;
            } else {
                break;
            }
        }
        
        return answer;
    }
}