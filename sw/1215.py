# swea 1215. 회문1

def palindrome_column(i,j):
    lst = graph[i][j:j+num]
    # print(lst)
    for i in range(num//2):
        if lst[i] != lst[-1-i]:
            return False
    # print('yes')
    return True

def palindrom_row(i,j):
    lst = [graph[temp][j] for temp in range(i,i+num)]
    # print(lst)
    for i in range(num//2):
        if lst[i] != lst[-1-i]:
            return False
    # print('yes')
    return True

for test_case in range(1,11):
    num = int(input())
    graph = [list(input()) for _ in range(8)]
    cnt = 0
    for i in range(8):
        for j in range(8-num+1):
            if palindrome_column(i,j):
                cnt += 1

    for i in range(8-num+1):
        for j in range(8):
            if palindrom_row(i,j):
                cnt += 1

    print(f'#{test_case} {cnt}')