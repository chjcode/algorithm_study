def solution(clothes):
    answer = 1
    dict = {}
    for cloth in clothes:
        if cloth[1] in dict.keys():
            dict[cloth[1]].append(cloth[0])
        else:
            dict[cloth[1]] = [cloth[0]]

    for cloth in dict.keys():
        answer *= (len(dict[cloth])+1)

    return answer-1