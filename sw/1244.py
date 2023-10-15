
def dfs(depth, n):
    global answer
    if depth == n:
        temp = ''.join(num)
        if answer < temp:
            answer = temp
        return

    for i in range(len_num):
        for j in range(i+1, len_num):
            num[i],num[j] = num[j],num[i]
            temp = ''.join(num)
            if visit.get((temp,depth),1):
                visit[(temp,depth)] = 0
                dfs(depth+1,n)
            num[i],num[j] = num[j],num[i]

T = int(input())
for test_case in range(1, T+1):
    num, n = input().split()
    num = list(num)
    len_num = len(num)
    visit = {}
    answer = '0'

    dfs(0,n)
    print(f'#{test_case} {answer}')