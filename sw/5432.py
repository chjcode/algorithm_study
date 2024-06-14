# swea 5432. 쇠막대기 자르기

t = int(input())
for tc in range(1,t+1):
    lst = list(input())

# lst = list('()(((()())(())()))(())')
    stack = []
    cnt = 0
    answer = 0
    for idx,s in enumerate(lst):

        if s == '(':
            cnt += 1
            print(idx, cnt, answer)
        else:
            if lst[idx-1] == '(':   # 레이저를 만나면 절단하고 개수 +
                cnt -= 1
                answer += cnt
            else:
                cnt -= 1    # 막대의 끝 지점을 만나면
                answer += 1

            print(idx, cnt, answer)

    print(f'#{tc} {answer}')

'''
입력
2
()(((()())(())()))(())
(((()(()()))(())()))(()())

출력
#1 17
#2 24
'''