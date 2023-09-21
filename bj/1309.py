# 1309 동물원

# 입력받기
n = int(input())
dp = [1 for _ in range(n+1)]

dp[1] = 3

if n == 1:
    print(dp[1])
else:
    for i in range(2,n+1):
        dp[i] = (2*dp[i-1] + dp[i-2]) % 9901
    print(dp[n])