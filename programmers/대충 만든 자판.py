from collections import deque

def solution(keymap, targets):
    answer = []
    dict = {}
    for i in keymap:
        for j,k in enumerate(i,start=1):
            if k not in dict.keys():
                dict[k] = j
            elif dict[k] > j:
                dict[k] = j

    for target in targets:
        cnt = 0
        check = True
        for alpha in target:
            if alpha not in dict.keys():
                answer.append(-1)
                check = False
                break
            else:
                cnt += dict[alpha]

        if check:
            answer.append(cnt)           

    return answer