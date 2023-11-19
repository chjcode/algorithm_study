# swea 1234. 비밀번호

import sys
sys.stdin = open("input (2).txt")

for test_case in range(1,11):
    n,str = input().split()
    flag = True
    while flag:
        flag = False
        for i in range(1,len(str)):
            if str[i-1] == str[i]:
                str = str[:i-1] + str[i+1:]
                flag = True
                break

    print(f"#{test_case} {str}")