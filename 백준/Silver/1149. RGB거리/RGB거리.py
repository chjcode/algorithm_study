n = int(input())
dp = [[0,0,0] for _ in range(n)]

color_cost = list(map(int,input().split()))
for i in range(3):  
    dp[0][i] = color_cost[i]


for i in range(1,n):
    color_cost = list(map(int,input().split()))
    
    dp[i][0] = color_cost[0] + min(dp[i-1][1],dp[i-1][2])
    dp[i][1] = color_cost[1] + min(dp[i-1][0],dp[i-1][2])
    dp[i][2] = color_cost[2] + min(dp[i-1][0],dp[i-1][1])

# print(dp)
print(min(dp[n-1]))
        