# 8983 사냥꾼

m,n,l = map(int,input().split())
hunter = sorted(list(map(int,input().split())))
animals = [list(map(int,input().split())) for _ in range(n)]
cnt = 0
   
for x,y in animals:
    if y > l:
        continue
    start = x+y-l
    end = x-y+l
    left = 0
    right = m-1
    while left <= right:
        middle = (left+right)//2
        if hunter[middle] >= start and hunter[middle] <= end:
            cnt += 1
            break
        if hunter[middle] < end:
            left = middle + 1
        else:
            right = middle - 1

print(cnt)