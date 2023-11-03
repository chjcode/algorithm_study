# swea 2005 파스칼의 삼각형

T = int(input())
for test_case in range(1,T+1):
    n = int(input())
    lst = []
    lst.append([1])
    lst.append([1,1])
    for i in range(2,n):
        temp = []
        for j in range(i+1):
            if j == 0 or j == i:
                temp.append(1)
            else:
                temp.append(lst[i-1][j-1]+lst[i-1][j])
        lst.append(temp)

    print(f"#{test_case}")
    for i in range(n):
        print(*lst[i])