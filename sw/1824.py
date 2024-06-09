# swea 1824.혁진이의 프로그램 검증

'''
% 를 이용해서 idx가 내부에서 유지되도록함
문자	수행 명령
<	이동 방향을 왼쪽으로 바꾼다.
>	이동 방향을 오른쪽으로 바꾼다.
^	이동 방향을 위쪽으로 바꾼다.
v	이동 방향을 아래쪽으로 바꾼다.
_	메모리에 0이 저장되어 있으면 이동 방향을 오른쪽으로 바꾸고, 아니면 왼쪽으로 바꾼다.
|	메모리에 0이 저장되어 있으면 이동 방향을 아래쪽으로 바꾸고, 아니면 위쪽으로 바꾼다.
?	이동 방향을 상하좌우 중 하나로 무작위로 바꾼다. 방향이 바뀔 확률은 네 방향 동일하다.
.	아무 것도 하지 않는다.
@	프로그램의 실행을 정지한다.
0~9	메모리에 문자가 나타내는 값을 저장한다.
+	메모리에 저장된 값에 1을 더한다. 만약 더하기 전 값이 15이라면 0으로 바꾼다.
-	메모리에 저장된 값에 1을 뺀다. 만약 빼기 전 값이 0이라면 15로 바꾼다.
'''

t = int(input())

for tc in range(1,t+1):
    r,c = map(int,input().split())
    graph = [list(input()) for _ in range(r)]
    visit = [[[] for j in range(c)] for i in range(r)]
    flag = False    # 종료 가능 여부

    stack = []
    stack.append((0,0,0,0,1))     # 0 : memory, 0,0 : 시작, 0,1 : 이동방향
    temp = 1
    while stack:
        print(temp)
        temp += 1
        memory,x,y,a,b = stack.pop()
        print('memory:',memory, 'x:',x,'y:',y,'a:',a,'b:',b)
        print('visit : ',visit[x][y])

        # 종료 조건 : 같은 자리에 같은 메모리, 같은 방향이면 반복되고 있는 것이므로 종료
        if (memory,a,b) in visit[x][y]:
            break

        if graph[x][y] == '<':
            visit[x][y].append((memory,0,-1)) # (memory, 이동방향a,b)
            stack.append((memory,x,y-1,0,-1))
        elif graph[x][y] == '>':
            visit[x][y].append((memory,0,1))
            stack.append((memory,x,y+1,0,1))
        elif graph[x][y] == '^':
            visit[x][y].append((memory,-1,0))
            stack.append((memory,x-1,y,-1,0))
        elif graph[x][y] == 'v':
            visit[x][y].append((memory,1,0))
            stack.append((memory,x+1,y,1,0))
        elif graph[x][y] == '_':
            if memory == 0:
                visit[x][y].append((memory,0,1))
                stack.append((memory,x,y+1,0,1))
            else:
                visit[x][y].append((memory,0,-1))
                stack.append((memory,x,y-1,0,-1))
        elif graph[x][y] == '|':
            if memory == 0:
                visit[x][y].append((memory,1,0))
                stack.append((memory,x+1,y,1,0))
            else:
                visit[x][y].append((memory,-1,0))
                stack.append((memory,x-1,y,-1,0))
        elif graph[x][y] == '?':    ##########
            dx = [0,0,-1,1]
            dy = [-1,1,0,0]
            for i in range(4):
                visit[x][y].append((memory,dx[i],dy[i]))
                stack.append((memory,x+dx[i],dy+dy[i]))
        elif graph[x][y] == '@':
            flag = True
            break
        elif graph[x][y] == '+':
            memory = (memory + 1) % 16
            visit[x][y].append((memory,a,b))
            stack.append((memory,x+a,y+b,a,b))
        elif graph[x][y] == '-':
            memory = (16 + memory - 1) % 16
            visit[x][y].append((memory,a,b))
            stack.append((memory,x+a,y+b,a,b))
        elif graph[x][y] in ['0','1','2','3','4','5','6','7','8','9','10','11','12','13','14','15']:
            memory = int(graph[x][y])
            visit[x][y].append((memory,a,b))
            stack.append((memory,x+a,y+b,a,b))
        elif graph[x][y] == '.':    # 아무것도 하지 않을 때는 어떻게 처리?
            visit[x][y].append((memory,a,b))
            stack.append((memory,x+a,y+b,a,b))
        print('visit : ',visit[x][y])
    print(f'#{tc} {flag}')
'''
입력
3
2 6
6>--v.
.^--_@
2 6
5>--v.
.^--_@
2 6
.>--v.
.^--?@

input.txt
출력
#1 YES
#2 NO
#3 YES

graph[i][j] 처리
처리한 결과에 따라 이동
반복
'''

