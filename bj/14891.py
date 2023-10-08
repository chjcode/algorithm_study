# 14891 톱니바퀴

'''
1 -> idx 2
2 -> idx 6, idx 2
3 -> idx 6, idx 2

오른쪽 회전 : idx -1
왼쪽 회전 : idx + 1
'''
# lst = [list(input()) for _ in range(4)]
# k = int(input())
# contact = [[6,2],[6,2],[6,2],[6,2]]
# for _ in range(k):
#     num,direction = map(int,input().split())
#     num = num-1
#     contact[num][0] = (contact[num][0]-direction+8)%8
#     contact[num][1] = (contact[num][1]-direction+8)%8
#     print(contact)
#     # 왼쪽 -> 하나가 계속 도는게 아니라 나머지도 맞춰서 돌려주고 그 담에 다시 와서 돌아야됨
#     d = direction
#     for i in range(num,0,-1):
#         while lst[i][contact[i][0]] != lst[i-1][contact[i-1][1]]:  # 극이 다르면 회전
#             contact[i-1][0] = (contact[i-1][0]+d+8)%8
#             contact[i-1][1] = (contact[i-1][1]+d+8)%8
#             print('왼쪽: ',contact)
#         d = (-d)

#     # 오른쪽
#     d = direction
#     for i in range(num,3):
#         while lst[i][contact[i][1]] != lst[i+1][contact[i+1][0]]:
#             contact[i+1][0] = (contact[i+1][0]+d+8)%8
#             contact[i+1][1] = (contact[i+1][1]+d+8)%8
#             print('오른쪽: ',contact)
#         d = (-d)


# cnt = 0
# if lst[0][contact[0][1]-2] == '1':
#     cnt += 1
# if lst[1][contact[1][1]-2] == '1':
#     cnt += 2
# if lst[2][contact[2][1]-2] == '1':
#     cnt += 4
# if lst[3][contact[3][1]-2] == '1':
#     cnt += 8
# print(cnt)

from collections import deque

def left(num,direction):
    if num < 0:
        return
    if lst[num][2] != lst[num+1][6]:
        left(num-1,-direction)
        lst[num].rotate(direction)

def right(num,direction):
    if num > 3:
        return
    if lst[num][6] != lst[num-1][2]:
        right(num+1, -direction)
        lst[num].rotate(direction)

lst = [deque(list(input())) for _ in range(4)]
k = int(input())

for _ in range(k):
    num,direction = map(int,input().split())
    num -= 1
    left(num-1,-direction)
    right(num+1,-direction)
    lst[num].rotate(direction)

cnt = 0
if lst[0][0] == '1':
    cnt += 1
if lst[1][0] == '1':
    cnt += 2
if lst[2][0] == '1':
    cnt += 4
if lst[3][0] == '1':
    cnt += 8

print(cnt)
