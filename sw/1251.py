# swea 1251. [S/W 문제해결 응용] 4일차 - 하나로 ####소숫점 반올림 알아보기 (ex 두번째 자리에서 반올림)

t = int(input())

for tc in range(1,t+1):
    n = int(input())
    x = list(map(int,input().split()))
    y = list(map(int,input().split()))
    graph = [[0 for j in range(n)] for i in range(n)]
    e = float(input())

    for i in range(n):
        for j in range(n):
            if i == j:
                graph[i][j] = 2e9
            else:
                # 거리구하기
                pay = e * ((x[i]-x[j])**2 + (y[i]-y[j])**2)
                graph[i][j] = pay
                graph[j][i] = pay

    for i in range(n):
        print(*graph[i])


    answer = 0
    visit = [[0 for j in range(n)] for i in range(n)]
    for i in range(n):
        temp = min(graph[i])
        idx = visit.index(temp)
        visit[i][idx] = 1
        visit[idx][i] = 1
        answer += min(graph[i])

    print(f'#{tc} {int(answer)}')


'''
환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E * L^2)만큼 지불
입력
10
2
0 0
0 100
1.0
4
0 0 400 400
0 100 0 100
1.0
6
0 0 400 400 1000 2000
0 100 0 100 600 2000
0.3
9
567 5 45674 24 797 29 0 0 0
345352 5464 145346 54764 5875 0 3453 4545 123
0.0005

re_sample_input.txt
출력
#1 10000
#2 180000
#3 1125000
. . .
'''