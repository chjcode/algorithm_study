# swea 3499. 퍼펙트 셔플

t = int(input())

for tc in range(1,t+1):
    n = int(input())
    lst = list(input().split())

    if n % 2 == 0:
        left = lst[:n//2]
        right = lst[n//2:]
    else:
        left = lst[:n//2+1]
        right = lst[n//2+1:]

    answer = ''
    for i in range(n//2):
        answer += left[i]
        answer += ' '
        answer += right[i]
        answer += ' '

    if n % 2 != 0:
        answer += left[-1]
        answer += ' '
    answer = answer.rstrip()

    print(f'#{tc} {answer}')