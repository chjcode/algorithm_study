# 10814 나이순 정렬

n  = int(input())

lst = []
for i in range(n):
    x,y = input().split()
    lst.append([x,y,i])
lst.sort(key=lambda x : (x[0],x[2]))

for i in range(n):
    print(*lst[i][:2])