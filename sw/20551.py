# swea 20551. 증가하는 사탕 수열
'''

4
3 2 1
1 2 3
3 5 5
5 6 6

#1 -1
#2 0
#3 1
#4 2	  예제1: 어떤 방식으로 먹더라도 사탕의 개수가 순증가하게 할 수 없다.
  예제2: 이미 조건이 만족되어 있다.
  예제3: 두 번째 상자에 들어 있는 사탕 1개를 먹으면 된다.
  예제4: 첫 번째 상자 사탕 1개, 두 번째 상자 사탕 1개를 먹으면 된다.

1. a > b, b < c 일 때 -> 5 2 3 -> a를 b보다 1작게 -> 4
2. a > b, b > c 일 때 -> 5 4 3 -> b를 c보다 1작게, a를 b보다 1작게 -> 6
3. a < b, b > c 일 때 -> 2 5 3 -> b를 c보다 1작게, a를 b보다 1작게 -> 4
4. a < b, b < c 일 때 -> 2 3 4 정답
'''

t = int(input())

for tc in range(1,t+1):
    a,b,c = map(int,input().split())
    answer = 0

    if b < 2:
        answer = -1
        print(f"#{tc} {answer}")

    elif c < 3:
        answer = -1
        print(f"#{tc} {answer}")
    else:
        if b >= c:
            answer += b-c+1
            b = c-1
        if a >= b:
            answer += a-b+1
            a = b-1
        print(f"#{tc} {answer}")



