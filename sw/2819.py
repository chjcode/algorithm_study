# swea 2819. 격자판의 숫자 이어 붙이기 -> 백트래킹, bfs



# def dfs(depth,cnt):
#     global answer
#     if cnt == 7:
#         print(lst)
#         # if bfs():
#         #     answer += 1
#         return

#     for i in range(depth,16):
#         lst.append(i)
#         dfs(i+1,cnt+1)
#         lst.pop()


def dfs(x,y,num,cnt):
    global answer_set
    if cnt == 7:
        answer_set.add(num)
        return

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or nx > 3 or ny < 0 or ny > 3:
            continue
        dfs(nx,ny,num+graph[nx][ny],cnt+1)

    return


t = int(input())

for tc in range(1,t+1):
    graph = [list(input().split()) for _ in range(4)]
    dx = [0,0,-1,1]
    dy = [-1,1,0,0]

    answer_set = set()
    answer = 0
    for i in range(4):
        for j in range(4):
            dfs(i,j,graph[i][j],1)


    print(f'#{tc} {len(answer_set)}')

'''
입력
1
1 1 1 1
1 1 1 2
1 1 2 1
1 1 1 1

sample_input.txt
출력
#1 23

'''