# sw 1974. 스도쿠 검증

def check_row(lst):
    for i in range(9):
        if len(set(lst[i])) != 9:
            return False
    return True

def check_column(lst):
    for i in range(9):
        temp = []
        for j in range(9):
            temp.append(lst[j][i])
        if len(set(temp)) != 9:
            return False
    return True

def check_3x3(lst):
    for i in range(0,9,3):
        for j in range(0,9,3):
            temp = []
            for k in range(i,i+3):
                for l in range(j,j+3):
                    temp.append(lst[k][l])
            if len(set(temp)) != 9:
                return False
    return True

def check(lst):
    if not check_row(lst):
        return 0
    if not check_column(lst):
        return 0
    if not check_3x3(lst):
        return 0
    return 1

T = int(input())
for test_case in range(1, T + 1):
    lst = [list(map(int,input().split())) for _ in range(9)]

    print(f"#{test_case} {check(lst)}")

