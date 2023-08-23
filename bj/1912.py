# 1912 연속합

n = int(input())
n_lst = list(map(int,input().split()))

for  i in range(1,n):
    n_lst[i] = max(n_lst[i],n_lst[i-1]+n_lst[i])

print(max(n_lst))