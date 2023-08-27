# 1083 소트
'''
사전순으로 가장 뒷서는 것
-> 되도록 큰 수가 앞에 와야 함
-> s의 횟수보다 뒤에 있는 idx의 큰 수는 맨앞으로 보낼 수 없음

1. a[0:s+1]만큼 탐색하여 가장 큰 수의 idx를 얻어냄
2. 가장 큰 수를 a[0]으로 보낼 때까지 Sort()
3. a[1:s+1]만큼 탐색하여 가장 큰 수의 idx를 얻어냄
4. 가장 큰 수를 a[1]로 보낼 때까지 Sort()

'''

# 입력 받기
n = int(input())
a = list(map(int,input().split()))
s = int(input())    # 교환 가능 횟수

i = 0
while s>0 and i<n:
    idx = a.index(max(a[i:min(n,i+s+1)]))   # 최댓값 idx 얻기, s가 n을 넘어가면 오류나므로 min(n,i+s+1)

    if idx != i:
        a[idx-1],a[idx] = a[idx],a[idx-1]
        s -= 1
    else:
        i += 1

print(*a)