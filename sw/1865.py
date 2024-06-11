# swea 1865. 동철이의 일 분배 git

from itertools import permutations

t = int(input())

for tc in range(1,t+1):
    n = int(input())
    graph = [list(map(int,input().split())) for _ in range(n)]
    lst = [i for i in range(n)]
    answer = 0

    for permu in permutations(lst,n):   #((0,1,2),(0,2,1),(1,0,2),,,)
        cal = 1
        for idx,num in enumerate(permu):    #(0,1,2)
            cal *= (graph[idx][num] / 100)
        answer = max(cal,answer)

    print(f'#{tc} {round(answer*100,6):.6f}')


'''
입력
1
3
13 0 50
12 70 90
25 60 100

출력
#1 9.100000
'''