n = int(input())
lst = [int(input()) for _ in range(n)]
dp = [0 for _ in range(n)]

if n == 1:
    print(lst[0])
elif n == 2:
    print(lst[0]+lst[1])
elif n == 3:
    print(max(lst[0] + lst[2],lst[1]+lst[2]))
else:
    dp[0] = lst[0]
    dp[1] = lst[0] + lst[1]
    dp[2] = max(lst[0] + lst[2],lst[1]+lst[2])

    for i in range(3,n):
        dp[i] = max(dp[i-2]+lst[i], dp[i-3]+lst[i-1]+lst[i])

    print(dp[n-1])