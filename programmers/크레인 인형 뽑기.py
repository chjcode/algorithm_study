#board : 2차원배열
#moves : 크레인 작동시킨 위치 배열
#answer : 터트려져 사라진 인형 개수
def solution(board, moves):
    answer = 0
    top = []
    lenb = len(board)
    for num in moves:
        grab = False    #인형 잡았는지 유무
        for i in range(lenb):    #인형 집기
            for j in range(num-1,num):
                if board[i][j] != 0:
                    if top:
                        if top[-1] == board[i][j]:
                            top.pop()
                            answer += 2
                        else:
                            top.append(board[i][j])
                    else:
                        top.append(board[i][j])
                    board[i][j] = 0
                    grab = True
            if grab == True:
                break
    
    return answer