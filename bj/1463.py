# 1463 1로 만들기 -> dp
'''
1부터 시작해서 3을 곱하고, 2를 곱하고, 1을 더해서 리스트를 초기화해 나감
'''
goal = int(input())
lst = [0 for i in range(goal + 1)]

for i in range(2,goal+1):
    lst[i] = lst[i-1] + 1
    if i % 2 == 0:
        lst[i] =  min(lst[i], lst[i//2]+1)
    if i % 3 == 0:
        lst[i] = min(lst[i], lst[i//3]+1)
print(lst)
print(lst[goal])