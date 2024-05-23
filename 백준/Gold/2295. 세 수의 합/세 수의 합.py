n = int(input())
lst = sorted([int(input()) for _ in range(n)])


# 두 수의 합을 저장할 집합 생성
sum_set = set()
for i in range(n):
    for j in range(i, n):
        sum_set.add(lst[i] + lst[j])

def solve():
    for i in range(n-1, -1, -1):
        for j in range(i):
            if lst[i] - lst[j] in sum_set:
                return lst[i]

    return None


print(solve())