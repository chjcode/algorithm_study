# 11651 좌표 정렬하기2

n = int(input())
lst = []
for _ in range(n):
    x,y = map(int,input().split())
    lst.append([x,y])

lst = sorted(lst,key=lambda x: (x[1],x[0]))

for i in range(n):
    print(*lst[i])