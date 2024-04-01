# def solution(board):
#     answer = 0
    
#     for i in range(1,len(board)):   #세로
#         for j in range(1,len(board[0])): #가로
#             if board[i][j] > 0 :
#                 board[i][j] = min(board[i-1][j-1],board[i-1][j],board[i][j-1]) + 1
    
    

#     return max(max(i) for i in board) ** 2

# 0 1 1 1
# 1 1 2 2
# 1 2 2 2
# 0 0 1 0

# 0 1 1 1
# 1 1 2 2
# 1 2 2 3
# 0 0 1 0


def solution(board):
    answer = 0
    
    for i in range(1,len(board)):
        for j in range(1,len(board[0])):
            if board[i][j] > 0:
                board[i][j] = min(board[i-1][j], board[i][j-1],board[i-1][j-1]) + 1
    
    for row in board:
        for num in row:
            answer = max(answer,num)
    
    return answer **2

















