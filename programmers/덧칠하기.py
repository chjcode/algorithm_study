def solution(n, m, section):
    answer = 1
    start = section[0]
    
    for i in section:
        if i - start >= m:  # 페인트 없는 다음 구역까지의 거리가 m보다 크면
            start = i   # 다음 구역을 start로 다시 지정해주고
            answer += 1 # 붓질 한번 추가
    
    return answer