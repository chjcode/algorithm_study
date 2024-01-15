# 2579 계단 오르기
'''
게임에서 얻을 수 있는 최댓값 구하기
한번에 한 계단 또는 두 계단 오를 수 있음
마지막 계단은 무조건 밟아야 함

계단의 개수가 300이하 , 1초 -> 10억 / 300  = 300만
o(n) -> 300
o(n^2) -> 90000
'''

n = int(input())
stair = [0]
for _ in range(n):
    stair.append(int(input()))

if n == 1:
    print(stair[1])
elif n == 2:
    print(stair[1] + stair[2])
else:
    dp = [0 for _ in range(n+1)]
    dp[1] = stair[1]
    dp[2] = stair[1] + stair[2]

    for i in range(3,n+1):
        dp[i] = max(dp[i-2] + stair[i], dp[i-3] + stair[i] + stair[i-1])

    print(dp[n])