class Solution {

    public int solution(int h1, int m1, int s1,
                        int h2, int m2, int s2) {

        // 시간을 초 단위로 변환
        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;

        // [0 ~ end]까지의 알람 횟수
        // - [0 ~ start]까지의 알람 횟수
        int answer = count(end) - count(start);

        // 시작 시각 자체가 알람이 울리는 순간이면 포함해야 함
        if (isOverlap(start)) {
            answer++;
        }

        return answer;
    }

    private int count(int t) {

        int result = 0;

        /*
         * 초침과 분침
         *
         * 초침 : 1초에 6도
         * 분침 : 1초에 0.1도
         *
         * 상대속도 = 6 - 0.1 = 5.9도/초
         *
         * 360도 차이가 나면 한 번 다시 만남
         *
         * 따라서
         * 만나는 주기 = 360 / 5.9 ≒ 61.0169초
         *
         * 1시간(3600초) 동안 59번 만남
         *
         * => t초 동안의 누적 횟수
         *    floor(t * 59 / 3600)
         */
        result += t * 59 / 3600;

        /*
         * 초침과 시침
         *
         * 시침은 12시간(43200초)에 360도 회전
         *
         * 시침 속도
         * = 360 / 43200
         * = 1 / 120도/초
         *
         * 상대속도
         * = 6 - 1/120
         *
         * 12시간 동안 719번 만남
         *
         * => t초 동안의 누적 횟수
         *    floor(t * 719 / 43200)
         */
        result += t * 719 / 43200;

        /*
         * 12:00:00 에서는
         * 시침, 분침, 초침이 모두 한 점에 있음
         *
         * 위 계산은
         * 초-분 1번
         * 초-시 1번
         * 으로 세므로 같은 순간을 2번 카운트함
         *
         * 따라서 12시를 지났다면 1번 빼줌
         */
        if (t >= 43200) {
            result--;
        }

        return result;
    }

    private boolean isOverlap(int t) {

        /*
         * 시작 시각 자체가 알람 발생 시각인지 확인
         *
         * 00:00:00
         * 12:00:00
         *
         * 에서는 세 바늘이 모두 겹침
         */
        return t == 0 || t == 43200;
    }
}