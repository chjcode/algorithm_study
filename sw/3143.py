# swea 3143. 가장 빠른 문자열 타이핑

t = int(input())

for tc in range(1,t+1):
    a,b = input().split()
    idx = 0
    answer = 0
    while idx < len(a):
        if a[idx:idx+len(b)] == b:
            idx += len(b)
            answer += 1
        else:
            idx += 1
            answer += 1


    print(f'#{tc} {answer}')

'''

6
banana bana
asakusa sa
a a
a b
ban bana
banb bana
bana bana
banab bana
출력
#1 3
#2 5
#3 1
#4 1
#5 3
#6 4
#7 1
#8 2
'''