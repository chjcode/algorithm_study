# sw 1209 2일차 - Sum

for _ in range(10):
    test_case = int(input())
    lst = [list(map(int,input().split())) for _ in range(100)]
    maxNum = -2e9

    # 행
    for i in range(100):
        maxNum = max(maxNum,sum(lst[i]))

    # 열
    for i in range(100):
        sumNum = 0
        for j in range(100):
            sumNum += lst[j][i]
        maxNum = max(maxNum,sumNum)

    # 대각선 좌->우
    sumNum = 0
    for i in range(100):
        sumNum += lst[i][i]
    maxNum = max(maxNum,sumNum)

    # 대각선 우->좌
    sumNum = 0
    for i in range(100):
        sumNum += lst[i][99-i]
    maxNum = max(maxNum,sumNum)

    print(f"#{test_case} {maxNum}")