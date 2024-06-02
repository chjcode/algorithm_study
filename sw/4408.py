# swea 4408. 자기 방으로 돌아가기 D4

t = int(input())

for tc in range(1,t+1):
    lst = [0 for _ in range(200)]
    n = int(input())
    for i in range(n):
        room_lst = sorted(list(map(int,input().split())))
        for j in range(2):
            if room_lst[j] % 2 == 1:
                room_lst[j] = room_lst[j] // 2
            else:
                room_lst[j] = (room_lst[j] // 2) - 1

        for j in range(room_lst[0], room_lst[1]+1):
            lst[j] += 1

    print(f'#{tc} {max(lst)}')




'''
입력
3
4
10 20
30 40
50 60
70 80
2
1 3
2 200
3
10 100
20 80
30 50
출력
#1 1
#2 2
#3 3
'''