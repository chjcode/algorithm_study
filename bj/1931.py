# 1931 회의실 배정

n = int(input())
time_lst = sorted([list(map(int,input().split())) for _ in range(n)], key = lambda x: (x[1],x[0]))

cnt = 1
end_time = time_lst[0][1]
for i in range(1,n):
    if time_lst[i][0] >= end_time:
        cnt += 1
        end_time = time_lst[i][1]
print(cnt)