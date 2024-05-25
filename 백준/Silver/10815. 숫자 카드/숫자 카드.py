N = int(input())
card = sorted(map(int,input().split()))
M = int(input())
M_lst = list(map(int,input().split()))
answer = []

def binary_search(array,target,start,end):
  while start <= end:
    mid = (start + end) // 2

    if array[mid] == target:
      return mid
    elif array[mid] > target:
      end = mid -1
    else:
      start = mid + 1
  
  return None

for i in range(M):
  if binary_search(card,M_lst[i],0,N-1) is not None:
    print(1, end=' ')
  else:
    print(0, end=' ')