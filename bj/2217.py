#  bj 2217 로프 -> 그리디

n = int(input())
k = [int(input()) for _ in range(n)]
k = sorted(k,reverse=True)

answer = []
for i in range(n):
    answer.append(k[i]*(i+1))

print(max(answer))