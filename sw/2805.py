# 2805 농작물 수확하기

'''
0,3
(1,2) (1,3) (1,4)
(2,1) (2,2) (2,3) (2,4) (2,5)
'''

T = int(input())

for test_case in range(1,T+1):
    n = int(input())
    farm = [list(map(int,list(input()))) for _ in range(n)]

    invest = 0
    # 위쪽
    for i in range(n//2):
        invest += sum(farm[i][n//2-i:n//2+i+1]) # [0,3:4] , [1,2:5] , [2,1:6]
    # 가운데
    invest += sum(farm[n//2])
    # 아래쪽
    for i in range(n-1,n//2,-1):    # [6,3] -> 6,5,4
        invest += sum(farm[i][n//2-(n-1-i):n//2+(n-i)])      # [6,3:4] , [5,2:3+(6-5)]
    
    print(f"#{test_case} {invest}")

