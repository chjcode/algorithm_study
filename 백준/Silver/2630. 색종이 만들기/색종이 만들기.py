# 2630 색종이 만들기
import sys
input = sys.stdin.readline
# 4. 색종이 나누는 함수
# x: 세로, y: 가로
def divide(x,y,n):
    color = paper[x][y]

    for i in range(x,x+n):
        for j in range(y,y+n):
            if paper[i][j] != color: # 다른 색깔의 종이가 발견되면
                div_n = n//2    # 색종이 한변의 길이를 반으로 나누기
                # 4개로 나누어진 색종이 각 구역 재귀로 순회
                divide(x,y,div_n)   # 1번째 구역 (0,0)
                divide(x,y+div_n,div_n) # 2번째 구역 (0,1)
                divide(x+div_n,y,div_n) # 3번째 구역 (1,0)
                divide(x+div_n,y+div_n,div_n)   # 4번째 구역 (1,1)
                return
    # 다른 색이 발견되지 않으면 온전한 색종이 이므로
    paper_dict[color] += 1

        

# 1. 종이 크기 입력 받기
n = int(input())
# 2. 종이 색 입력 받기
paper = []
for i in range(n):
    paper.append(list(map(int,input().split())))

# 3. 색깔 별 종이 개수 설정
paper_dict = {0:0, 1:0}

# 5. 색종이 나누기
divide(0,0,n)

# 6. 출력
print(paper_dict[0])    #흰색
print(paper_dict[1])    #파란색