# swea 1860. 진기의 최고급 붕어빵
import sys
sys.stdin = open("input (1).txt")

T = int(input())
for test_case in range(1,T+1):
    n,m,k = map(int,input().split())
    time = sorted(list(map(int,input().split())))

    answer = "Possible"
    for i in range(n):
        bread = (time[i]//m) * k - (i+1)
        if bread < 0:
            answer = "Impossible"
            break
    print(f"#{test_case} {answer}")

# 시간 초과 코드
# import sys
# sys.stdin = open("input (1).txt")
# T = int(input())
#
# for test_case in range(1,T+1):
#     n,m,k = map(int,input().split())    #n명의 사람, m초에 k개의 붕어빵
#     lst = sorted(list(map(int,input().split())),reverse=True)
#     time = [0 for _ in range(lst[0]+1)]
#
#     answer = "Possible"
#     for t in range(1, lst[0]+1):
#         time[t] = time[t-1]
#         if t % m == 0:
#             time[t] = time[t-1] + k
#         if t == lst[-1]:
#             temp = lst.pop()
#             time[t] -= 1
#             if time[t] < 0:
#                 answer = "Impossible"
#                 break
#     print(f"#{test_case} {answer}")