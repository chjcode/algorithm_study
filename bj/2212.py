# 2212 센서


# 입력 받기
n = int(input())
k = int(input())
sensor = sorted(list(map(int,input().split())))

dis = []
for i in range(0,n-1):
    dis.append(sensor[i+1] - sensor[i])
dis.sort()

print(sum(dis[:n-k]))


