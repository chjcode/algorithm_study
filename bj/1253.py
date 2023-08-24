# 1253 좋다
'''
투포인터
'''

from itertools import combinations

# 입력 받기
n = int(input())
lst = sorted(map(int,input().split()))
good = 0

for i in range(n):
    new_lst = lst[:i] + lst[i+1:]   # 시간 복잡도를 줄이기 위해 자기 자신 제외
    left = 0
    right = n-2 # new_lst의 마지막 idx

    while left < right:
        s = new_lst[left] + new_lst[right]  # 두 수의 합
        if s == lst[i]:
            good += 1
            break
        elif s < lst[i]:    # 정렬 되어 있으므로 합이 더 작으면 left+=1해서 합을 키움
            left += 1
        else:
            right -= 1

print(good)