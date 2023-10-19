# 2910 빈도 정렬

n,c = map(int,input().split())
numbers = list(map(int,input().split()))

dic = {}
for idx,num in enumerate(numbers):
    if num in dic:
        dic[num][0] += 1
    else:
        dic[num] = [1,idx,num]  # 횟수 , 순서

lst = sorted(dic.values(), key=lambda x:(-x[0],x[1]))
answer = []
for temp in lst:
    for i in range(temp[0]):
        answer += [temp[2]]

print(*answer)
