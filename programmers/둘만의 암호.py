def solution(s, skip, index):
    answer = ''
    alpha = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
    
    for i in s:
        for j in range(26):
            if i == alpha[j]:
                cnt = 0
                idx = j
                while cnt != index:
                    idx = (idx + 1)%26
                    if alpha[idx] not in skip:
                        cnt += 1
                answer += alpha[idx]
    return answer