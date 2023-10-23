# 11047 동전 0

n,k = map(int,input().split())
coins = sorted([int(input()) for _ in range(n)])

s = k
cnt = 0
while True:
    if s == 0:
        print(cnt)
        break
    temp = s//coins[-1]
    if temp > 0:
        cnt += (s//coins[-1])
        s -= (temp*coins[-1])
        coins.pop()
    else:
        coins.pop()