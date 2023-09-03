# programmers 정수 삼각형

def solution(triangle):
    '''
                (0,0)
            (1,0)(1,1)
        (2,0),(2,1),(2,2)
    (3,0),(3,1),(3,2),(3,3)
    아래칸으로 갈때는 오른쪽 또는 왼쪽으로 이동 가능
    -> (dx+1,그대로) or (dx+1,dy+1)
    '''

    len_triangle = len(triangle)

    dp = [[0 for j in range(i+1)] for i in range(len_triangle)]
    dp[0][0] = triangle[0][0]
    for i in range(len_triangle-1):
        for j in range(i+1):
            dp[i+1][j] = max(dp[i+1][j],dp[i][j]+triangle[i+1][j])
            dp[i+1][j+1] = max(dp[i+1][j+1],dp[i][j]+triangle[i+1][j+1])

    return max(dp[-1])