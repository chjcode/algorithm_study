# swea 5356. 의석이의 세로로 말해요

t = int(input())

for tc in range(1,t+1):
    answer = ''
    temp = [['' for _ in range(15)] for _ in range(5)]
    max_len = 0
    for i in range(5):  # 입력 받기
        lst = list(input())
        len_lst = len(lst)
        max_len = max(max_len, len_lst)
        for j in range(len_lst):
            temp[i][j] = lst[j]

    # 세로로 만들어서 저장
    answer = ''

    for j in range(max_len):
        for i in range(5):
            answer += temp[i][j]

    print(f'#{tc} {answer}')

'''
입력
2
ABCDE
abcde
01234
FGHIJ
fghij
AABCDD
afzz
09121
a8EWg6
P5h3kx

출력
#1 Aa0FfBb1GgCc2HhDd3IiEe4Jj
#2 Aa0aPAf985Bz1EhCz2W3D1gkD6x	//TC #1의 정답
'''