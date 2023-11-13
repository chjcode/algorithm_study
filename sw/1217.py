# swea 1217. 거듭 제곱

def dfs(x,depth):
    if depth == m:
        print(f"#{test_case} {x}")
        return
    x *= n
    return dfs(x,depth+1)

for _ in range(10):
    test_case = int(input())
    n,m = map(int,input().split())
    dfs(1,0)
