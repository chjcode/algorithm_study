lst = list(input().split())
n = int(lst[0])

while len(lst) < n+1:
    lst += list(input().split())

lst = lst[1:]

for i in range(n):
    lst[i] = int(''.join(list(lst[i])[::-1]))

lst = sorted(lst)

for num in lst:
    print(num)