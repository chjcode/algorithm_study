dp = [0 for i in range(1001)]

n = int(input())

if n < 3:
    print(n)
else:
    dp[0] = 1
    dp[1] = 2
    dp[2] = 3
    for i in range(3,n):
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10007
    print(dp[n-1])