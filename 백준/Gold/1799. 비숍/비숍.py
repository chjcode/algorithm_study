n = int(input())
table = [list(map(int, input().split())) for _ in range(n)]
right = [[0] * n for _ in range(n)]
left = [[0] * n for _ in range(n)]
r, l = 1, 1

# 오른쪽 대각선 방향 탐색 개선
for i in range(2 * n - 1):
    for j in range(max(0, i - n + 1), min(i + 1, n)):
        if table[j][i - j] == 1:
            right[j][i - j] = r
    r += 1

# 왼쪽 대각선 방향 탐색 개선
for i in range(2 * n - 1):
    for j in range(max(0, i - n + 1), min(i + 1, n)):
        if table[j][n - 1 - (i - j)] == 1:
            left[j][n - 1 - (i - j)] = l
    l += 1

# 1<= l, r <=2*n
link = [[] for _ in range(l)]
for i in range(n):
    for j in range(n):
        if table[i][j]:
            link[left[i][j]].append(right[i][j])

def dfs(idx):
    visited[idx] = True
    l = link[idx]
    for p in l:
        if r2l[p] == 0 or (not visited[r2l[p]] and dfs(r2l[p])):
            r2l[p] = idx
            l2r[idx] = p
            return True
    return False

l2r = [0] * (2*n)
r2l = [0] * (2*n)
ans = 0
for i in range(1, 2*n):
    visited = [False] * (2*n)
    if dfs(i):
        ans += 1
print(ans)
