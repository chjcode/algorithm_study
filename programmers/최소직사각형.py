#sizes : 명함크기 2차원 배열
#answer : 모든 카드 수납 가능한 지갑의 넓이
def solution(sizes):
    
    long = []
    short = []
    
    for i,j in sizes:
        if i < j :
            short.append(i)
            long.append(j)
        else:
            long.append(i)
            short.append(j)
    
    answer = max(long) * max(short)
            
    
    return answer