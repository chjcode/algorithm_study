n = int(input())
lst = sorted(list(map(int,input().split())))
answer = 0

for i in range(n):
    answer += sum(lst[:i+1])
    
print(answer)
