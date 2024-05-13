# 1920 수찾기

n = int(input())
n_set = set(map(int,input().split()))
m = int(input())
m_lst = list(map(int,input().split()))

for num in m_lst:
    if num in n_set:
        print(1)
    else:
        print(0)