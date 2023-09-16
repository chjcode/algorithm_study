# 2979 트럭 주차

a,b,c = map(int,input().split())
time = [0 for _ in range(101)]

for _ in range(3):
    arrive, leave = map(int,input().split())
    for i in range(arrive,leave):
        time[i] += 1

charge = 0

for i in range(101):
    if time[i] == 1:
        charge += a
    elif time[i] == 2:
        charge += b*2
    elif time[i] == 3:
        charge += c*3

print(charge)