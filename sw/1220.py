# swea 1220. Magnetic
# 1 : n 극(아래로 이동) 2: s극(위로 이동)
for test_case in range(1,11):
    n = int(input())
    graph = [list(map(int,input().split())) for _ in range(100)]
    cnt = 0

    red = []
    blue = []
    for i in range(100):
        for j in range(100):
            if graph[i][j] == 1:
                red.append([i,j])
            if graph[i][j] == 2:
                blue.append([i,j])
    len_red = len(red)
    len_blue = len(blue)
    for i in range(100):
        for r in range(len_red):
            x,y = red[r]
            if 0 <= x < (n-1) and 0 <= y < (n-1):
                if graph[x+1][y] != 0:
                    continue
            red[r][0] += 1
        for b in range(len_blue):
            x,y = blue[r]
            if 0 <= x < (n-1) and 0 <= y < (n-1):
                if graph[x-1][y] != 0:
                    continue
            blue[b][0] -= 1

    for r in range(len_red):
        x,y = red[r]
        if 0 <= x < (n-1) and 0 <= y < (n-1):
            if graph[x+1][y] == 2:
                cnt += 1

    print(f"#{test_case} {cnt}")

# 100번 돌리면 됨
# n극(1값)바로 밑에 s극 있으면 +1해서 교착 개수 세기
