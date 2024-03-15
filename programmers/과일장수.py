# k: 사과 최대 점수
# m : 한 상자에 들어가는 사과의 수
# 최저 * m * 상자 수
def solution(k, m, score):
    answer = 0
    temp = []
    s_idx = [1 for i in range(len(score))]
    cnt = 0 #사과 개수 count
    for i in range(k,0,-1):
        
        for j in range(len(score)):
            if cnt == m:
                answer = min(temp) * m + answer
                temp = []
                cnt = 0
            
            if score[j] == i and s_idx[j] == 1:
                temp.append(score[j])
                s_idx[j] -= 1
                cnt += 1
        if cnt == m:
            answer = min(temp) * m + answer
            temp = []
            cnt = 0

    return answer