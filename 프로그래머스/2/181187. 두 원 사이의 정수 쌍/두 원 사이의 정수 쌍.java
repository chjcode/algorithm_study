class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        // 1사분면에서 x>0, y>0 인 점만 센다
        for (long x = 1; x <= r2; x++) {
            long yMax = (long)Math.sqrt((long)r2 * r2 - x * x);

            long temp = (long)r1 * r1 - x * x;

            // ceil(sqrt(temp))를 ceil 없이 구현:
            // temp>0이면  floor(sqrt(temp-1))+1  == ceil(sqrt(temp))
            long yMin = 0;
            if (temp > 0) yMin = (long)Math.sqrt(temp - 1) + 1;

            // 축(y=0)은 제외하려고 y를 최소 1부터 시작 (y>0만 세기)
            if (yMin < 1) yMin = 1;

            if (yMax >= yMin) {
                answer += (yMax - yMin + 1);
            }
        }

        // 4사분면 대칭
        answer *= 4;

        // 축 위 점들 추가: (±k,0), (0,±k) for k=r1..r2
        answer += 4L * (r2 - r1 + 1);

        return answer;
    }
}