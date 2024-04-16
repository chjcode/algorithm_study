# 1780 종이의 개수
import sys
input = sys.stdin.readline
# 4. 다른 종류이면 분할하는 함수
def divide(x,y,n):
    start = paper[x][y] # 종이 시작 좌표(시작할 때의 종류와 계속해서 같아야함)

    for i in range(x,x+n):
        for j in range(y,y+n):
            if paper[i][j] != start:    # 시작할 때의 종이 종류와 다르면
                # 종이를 1/3로 분할해서 다시 확인
                div_n = n//3
                # 각 9개의 구역 재귀를 통해 확인
                divide(x,y,div_n)   # 1번째 구역 (0,0)
                divide(x,y+div_n,div_n) # 2번째 구역 (0,1)
                divide(x,y+(2*div_n),div_n) # 3번째 구역 (0,2)
                divide(x+div_n,y,div_n) # 4번째 구역 (1,0)
                divide(x+div_n,y+div_n,div_n) # 5번째 구역 (1,1)
                divide(x+div_n,y+(2*div_n),div_n) # 6번째 구역 (1,2)
                divide(x+(2*div_n),y,div_n) # 7번째 구역 (2,0)
                divide(x+(2*div_n),y+div_n,div_n) # 8번째 구역 (2,1)
                divide(x+(2*div_n),y+(2*div_n),div_n) # 9번째 구역 (2,2)
                return
    # for문을 모두 돌았을 때 다른 종류의 종이가 없으면
    paper_dict[start] += 1  # 종이 종류별로 개수 count
    return

# 1. 종이 크기 입력
n = int(input())
# 2. paper
paper = []
for i in range(n):
    paper.append(list(map(int,input().split())))

# 3. 종이 종류
paper_dict = {-1:0, 0:0, 1:0}

# 5. 분할
divide(0,0,n)

# 6 출력
print(paper_dict[-1])
print(paper_dict[0])
print(paper_dict[1])