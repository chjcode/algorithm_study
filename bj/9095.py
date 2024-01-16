# 9095 1,2,3 더하기 -> dp

t = int(input())

for _ in range(t):
    n = int(input())
    lst = [0 for _ in range(n+1)]

    if n < 2:
        print(1)
        continue
    elif n < 3:
        print(2)
        continue
    elif n < 4:
        print(4)
        continue
    else:
        lst[1] = 1
        lst[2] = 2
        lst[3] = 4
        for i in range(4,n+1):
            lst[i] = lst[i-1] + lst[i-2] + lst[i-3]
        print(lst[n])