# swea 3431. 준환이의 운동관리

'''
[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 세 정수 L, U, X(0≤ L ≤ U ≤ 107, 0 ≤ X ≤ 107)가 공백으로 구분되어 주어진다.


[출력]

각 테스트 케이스마다 I가 필요한 양보다 더 많은 운동을 하고 있다면 -1을 출력하고, 아니라면 추가로 몇 분을 더 운동해야 하는지 출력한다.
'''

t = int(input())

for tc in range(1,t+1):
    l,u,x = map(int,input().split())    # L분 이상 U분 이하의 운동

    answer = -1

    if x <= l:
        answer = l-x
    elif x <= u:
        answer = 0

    print(f'#{tc} {answer}')
'''
입력
3
300 400 240
300 400 350
300 400 480
sample_input.txt
출력
#1 60
#2 0
#3 -1
'''