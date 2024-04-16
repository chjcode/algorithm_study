# 1992 쿼드트리
import sys
input = sys.stdin.readline

# 3. 영상 압축 합수 만들기
# x: 세로, y: 가로
def compress(x,y,n):
    start = video[x][y] # 시작 지점의 색 저장해두기
    for i in range(x,x+n):  
        for j in range(y,y+n):
            if video[i][j] != start:    # 다른색 나오면
                start = -1
                break

    if start == -1:
        print('(',end='')
        div_n = n//2    # 4개의 영상으로 나누기
        # 4 부분 모두 재귀로 확인
        compress(x,y,div_n) # 1번째 영역 (0,0)
        compress(x,y+div_n,div_n)   # 2번째 영역 (0,1)
        compress(x+div_n,y,div_n)   # 3번째 영역 (1,0)
        compress(x+div_n,y+div_n,div_n) #4번째 영역 (1,1)
        print(')',end='')
    elif start == 1:
        print(1,end='')
    else:
        print(0,end='')

# 1. 영상 크기 입력 받기
n = int(input())

# 2. 영상 입력 받기
video = []
for i in range(n):
    video.append(list(map(int,input().rstrip())))

result = [] # 압축 결과 저장 변수

# 4. 영상 압축
compress(0,0,n)