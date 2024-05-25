a, b = map(int,input().split())
a_set = set(map(int,input().split()))
b_set = set(map(int,input().split()))
answer = sorted(list(a_set - b_set))

print(len(answer))
print(*answer)