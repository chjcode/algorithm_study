# swea 1228. [S/W 문제해결 기본] 8일차 - 암호문1 

t = 10
for tc in range(1,t+1):
    n = int(input())
    lst = list(map(int,input().split()))
    m = int(input())
    orders = list(input().split('I'))
    # print('orders : ',orders)
    # print()

    for order in orders[1:]:
        order = order.split()
        # print('order : ',order)
        lst = lst[:int(order[0])] + list(map(int,order[2:])) + lst[int(order[0]):]
        # print(order[0], 'answer  : ',lst)
        # print()
    print(f'#{tc}',*lst[:10])
