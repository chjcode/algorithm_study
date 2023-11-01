# sw 2007 패턴의 길이
t = int(input())

for test_case in range(1,t+1):
    lst = input()
    cnt = 1
    while True:
        if lst[:cnt] == lst[cnt:2*cnt]:
            print(f"#{test_case} {cnt}")
            break
        else:
            cnt += 1
