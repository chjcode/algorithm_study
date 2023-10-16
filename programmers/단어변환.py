# 프로그래머스 단어변환
from collections import deque

def solution(begin, target, words):
    global visited,answer
    if target not in words:
        return 0
    answer = []
    visited = [0] * len(words)
    bfs(begin,target,words)

    return min(answer)


def bfs(begin,target,words):
    global answer
    deq = deque()
    deq.append([begin,0])
    while deq:
        x, count = deq.popleft()
        if x == target:
            answer.append(count)
            break
        for i in range(len(words)):
            temp_cnt = 0
            if visited[i] == 0:
                for j in range(len(x)): #글자 수 차이 확인
                    if x[j] != words[i][j]:
                        temp_cnt += 1
                if temp_cnt == 1:   #한개 차이나면
                    deq.append([words[i],count+1])
                    visited[i] = 1
