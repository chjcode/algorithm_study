import sys
input = sys.stdin.readline

n = int(input())
lst = []
for i in range(n):
    x,y = input().split()
    lst.append((int(x),y,i))

lst = sorted(lst, key = lambda x : (x[0],x[2]))

for i in range(n):
    print(lst[i][0],lst[i][1])