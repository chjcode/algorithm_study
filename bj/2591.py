# 2591 숫자카드 -> dp

# 입력받기
cards = input()
n = len(cards)

dp = [[0 for j in range(n)] for i in range(2)]
dp[0][0] = 1
dp[0][1] = 0

for i in range(1,n):
    if 10 <= int(cards[i-1:i+1]) < 35:
        dp[1][i] = dp[0][i-1]
    if cards[i] == '0':
        continue
    dp[0][i] = dp[0][i-1] + dp[1][i-1]

print(int(dp[0][n-1]) + int(dp[1][n-1]))