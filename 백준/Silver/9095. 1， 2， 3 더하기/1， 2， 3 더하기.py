t = int(input())
for tc in range(t):
    n = int(input())
    lst = [0 for _ in range(n+1)]

    if n == 1:
        print(1)
    elif n == 2:
        print(2)
    elif n == 3:
        print(4)
    else:
        lst[1] = 1
        lst[2] = 2
        lst[3] = 4
        for i in range(4,n+1):
            lst[i] = sum(lst[i-3:])
        
        # print(lst)
        print(lst[n])