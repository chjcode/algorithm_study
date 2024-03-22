from collections import deque

def solution(cards1, cards2, goal):
    answer = 'Yes'
    deq1 = deque(cards1)
    deq2 = deque(cards2)
    for word in goal:
        if deq1 and word == deq1[0]:  #deq1이 비게 되면 오류나므로 deq1을 조건에 포함
            deq1.popleft()
        elif deq2 and word == deq2[0]:
            deq2.popleft()
        else:
            answer = 'No'
    
    return answer
