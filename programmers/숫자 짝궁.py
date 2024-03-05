# 다른방법 다시 풀어보기
def solution(X, Y):
    answer = ''
    X_dic = {0:0,1:0,2:0,3:0,4:0,5:0,6:0,7:0,8:0,9:0}
    
    for i in X:
        X_dic[int(i)] += 1
    for i in Y:
        if X_dic[int(i)] > 0:
            X_dic[int(i)] -= 1
            answer += i
    
    
    if answer == '':
        answer += '-1'
    elif len(answer) == answer.count('0'):
        answer = '0'
    else:
        answer = ''.join(sorted(answer,reverse = True))
    
    
    return answer