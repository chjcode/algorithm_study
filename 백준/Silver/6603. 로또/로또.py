# 6603 로또

# 1. 입력 받기
# 2. 주어진 lst에서 6개 고르기

def dfs(depth, cnt, lst):
    if depth == k:
        if cnt == 6:
            print(*lst)
        return

    dfs(depth+1, cnt+1, lst + [s[depth]])
    dfs(depth+1, cnt, lst)

    return

while True:
    inpt = input()
    if inpt == '0':
        break

    temp = list(map(int,inpt.split()))
    k = temp[0]
    s = temp[1:]

    dfs(0,0,[])
    print()
