# 1107 리모컨

n = int(input())
m = int(input())
if m:
    lst = input().split()
else:
    lst = []

answer = abs(100-n)
for number in range(1000001):
    for num in str(number):
        if num in lst:
            break
    else:
        answer = min(answer, len(str(number)) + abs(number-n))
print(answer)