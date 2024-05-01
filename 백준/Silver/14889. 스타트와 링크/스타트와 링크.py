from itertools import combinations
def dfs(depth,cnt):
    global answer

    if cnt == n//2:   # 팀 선정 끝나면 점수차 확인
        scoreA = 0
        scoreB = 0
        for x,y in combinations(teamA,2):
            scoreA += (graph[x][y] + graph[y][x])
        for x,y in combinations(member-set(teamA),2):
            scoreB += (graph[x][y] + graph[y][x])

        answer = min(answer, abs(scoreA-scoreB))

        return

    for i in range(depth,n):
        teamA.append(i)
        dfs(i+1,cnt+1)
        teamA.pop()

    return

n = int(input())
graph = [list(map(int,input().split())) for _ in range(n)]
member = set(i for i in range(n))
teamA = []
answer = 2e9  # 점수차

dfs(0,0)

print(answer)