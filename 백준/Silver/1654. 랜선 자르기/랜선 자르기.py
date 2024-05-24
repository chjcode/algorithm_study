K,N = map(int,input().split())  # K개로 N개의 랜선을만든다.
k = []
for _ in range(K):
  k.append(int(input()))
k = sorted(k)
start = 1
end = sum(k)//N #총 길이를 N으로 나눈것보다 더 작은 길이가 나올 수 밖에 없으므로

while start <= end:
  mid = (start + end)//2
  cnt = sum([x//mid for x in k])
  if cnt < N:
    end = mid-1
  elif cnt >= N:
    start = mid+1
    answer = mid
print(answer)
