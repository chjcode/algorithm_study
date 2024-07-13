class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++){
            int temp = 1000001;
            for(int j = queries[i][0]; j <= queries[i][1]; j++){
                if (queries[i][2] < arr[j] && arr[j] < temp) {
                    temp = arr[j];
                }
            }
            if (temp == 1000001){
                answer[i] = -1;
            } else{
                answer[i] = temp;
            }
        }
        return answer;
    }
}