# swea 6190 정곤이의 단조 증가하는 수 -> 구현

import sys
sys.stdin = open("s_input.txt")

T = int(input())    # test_case개수
for test_case in range(1,T+1):
    n = int(input())
    lst = list(map(int,input().split()))
    # 경우의 수로 모든 case 다 찾아서 조건에 만족하는지 확인
    # 중복 x, 순서 상관 o -> permutations

    from itertools import permutations

    answer = 0
    if n == 1:
        print(f"#{test_case} {lst[0]}")
    else:
        print(list(permutations(lst,2)))
        for numbers in permutations(lst,2):
            x,y = numbers
            if answer < x*y:
                # 단조 증가 체크
                strXY = str(x*y)
                flag = True
                for i in range(1,len(strXY)):
                    if strXY[i-1] > strXY[i]:
                        flag = False
                        break
                if flag:
                    answer = x*y
    if n != 1:
        if answer == 0:
            print(f"#{test_case} {-1}")
        else:
            print(f"#{test_case} {answer}")