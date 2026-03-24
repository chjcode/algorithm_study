import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        
        List<Integer> arr = new ArrayList<>();
        arr.add(k);

        while (k > 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            arr.add(k);
        }

        double[] area = new double[arr.size()];
        for (int i = 1; i < arr.size(); i++) {
            area[i] = area[i - 1] + (arr.get(i - 1) + arr.get(i)) / 2.0;
        }

        double[] answer = new double[ranges.length];
        int last = arr.size() - 1;

        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = last + ranges[i][1];

            if (start > end) {
                answer[i] = -1.0;
            } else {
                answer[i] = area[end] - area[start];
            }
        }

        return answer;
    }
}