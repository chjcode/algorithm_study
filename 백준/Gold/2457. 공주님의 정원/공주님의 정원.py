import sys
input = sys.stdin.readline

n = int(input())
flower = sorted([list(map(int,input().split())) for _ in range(n)],key = lambda x : (x[2],x[3],x[0],x[1]))
answer = 0

dic = {1:31, 2: 28, 3:31, 4:30, 5:31, 6:30, 7:31, 8:31, 9:30, 10:31, 11:30, 12:31}
day = [0 for _ in range(13)]
for i in range(1,13):
    day[i] = day[i-1] + dic[i]

start = 60   # 피는 날짜
end = 334 # 지는 날짜

idx = n-1
lst = []

while True:
    if start > end:    # 3월1일을 숫자로 변환한 값보다 꽃이 지는 날짜를 변환한 값이 더 작으면 멈춤
        break

    for i in range(idx,-1,-1):  # 꽃이 지는 날짜보다 큰 값을 다 집어넣음
        e = day[flower[i][2]-1] + flower[i][3]
        if end < e:
            s = day[flower[i][0]-1] + flower[i][1]
            lst.append(s)
        else:
            idx = i     # 정렬해놨으므로 꽃이 지는 날짜보다 작은 값이 나오면 멈춤
            break
    # 꽃이 지는 날짜보다 큰 값인 애들 중에 가장 일찍 피는 꽃으로 고름
    if lst:
        min_lst = min(lst)-1
        if end > min_lst:
            end = min_lst
            answer += 1
            lst = []
        else:
            answer = 0
            break

    else:   # lst가 비어있다는 뜻은 조건을 만족하지 않는다는 뜻이므로 멈춤
        answer = 0
        break

print(answer)