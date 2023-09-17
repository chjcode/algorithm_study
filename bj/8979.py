# 8979 올림픽


# 입력 받기
n,k = map(int,input().split())
n_lst = [list(map(int,input().split())) for _ in range(n)]
# 금,은,동 메달 개수 순서로 정렬
n_lst = sorted(n_lst,key=lambda x:(x[1],x[2],x[3]),reverse=True)
# print(n_lst)

rank = 1    # 순위
cnt = 0     # 같은 순위 카운트
pre = n_lst[0][1:]

if n_lst[0][0] == k:
    print(rank)

else:
    for i in range(1,n):
        if n_lst[i][1:] == pre: # 메달 개수가 같으면 공동순위 이므로
            cnt += 1    # 같은 순위 +1

        else:   # 메달 개수가 다르면 rank +
            pre = n_lst[i][1:]
            rank += cnt+1
            cnt = 0

        if n_lst[i][0] == k:
            print(rank)
            break
