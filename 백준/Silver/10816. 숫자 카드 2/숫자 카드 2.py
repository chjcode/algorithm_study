# 10816 숫자 카드 2

n = int(input())
n_lst = list(map(int,input().split()))
m = int(input())
m_lst = list(map(int,input().split()))

dic = dict()
for num in n_lst:
    if num in dic:
        dic[num] += 1
    else:
        dic[num] = 1

answer = []
for num in m_lst:
    if num in dic:
        answer.append(dic[num])
    else:
        answer.append(0)

print(*answer)
