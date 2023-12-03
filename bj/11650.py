# 11650 좌표 정렬하기

n = int(input())
lst = []
for _ in range(n):
    x,y = map(int,input().split())
    lst.append([x,y])

lst = sorted(lst,key=lambda x: (x[0],x[1]))

for i in range(n):
    print(*lst[i])