'''
k가 3이면 3일동안의 점수 중 최하점이 result로 들어감
'''
def solution(k, score):
    answer = []
    k_lst = []  #명예의 전당
    cnt = 0 # k번 확인해줄 변수
    for i in score:
        k_lst.append(i)
        k_lst = sorted(k_lst,reverse=True)[:k]
        answer.append(k_lst[-1])
    
    return answer