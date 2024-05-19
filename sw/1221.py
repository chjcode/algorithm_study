# swea 1221. [S/W 문제해결 기본] 5일차 - GNS

from functools import cmp_to_key

def compare(a,b):
    if dic[a] > dic[b]:
        return 1
    elif dic[a] < dic[b]:
        return -1
    else:
        return 0


t = int(input())

num_lst = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]

for _ in range(1,t+1):
    tc, len_lst = input().split()
    lst = list(input().split())
    dic = dict()

    for i in range(10):
        dic[num_lst[i]] = i

    lst = sorted(lst, key = cmp_to_key(compare))
    print(lst)