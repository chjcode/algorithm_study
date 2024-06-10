
# swea 1486. 장훈이의 높은 선반
# B 이상인 탑 중에서 탑의 높이와 B의 차이가 가장 작은 것을 출력한다.
# 탑의 높이는 점원이 1명일 경우 그 점원의 키와 같고, 2명 이상일 경우 탑을 만든 모든 점원의 키의 합과 같다.
'''
1. n = 1일때, n > 1 일때로 나눠야함
2. n = 1 ->
3. n > 1 ->
'''
from itertools import combinations

t = int(input())

for tc in range(1,t+1):
    n,b = map(int,input().split())  # b : b값 이상인 탑, n : 점원 명수
    n_lst = list(map(int,input().split()))  # 점원 키 리스트
    answer = 2e9

    for i in range(n,0,-1):
        for combi in combinations(n_lst,i):
            temp = sum(combi)
            if temp >= b:
                answer = min(answer,temp-b)

    print(f'#{tc} {answer}')


'''
입력
1
5 16
1 3 3 5 6

input.txt
출력
#1 1
'''