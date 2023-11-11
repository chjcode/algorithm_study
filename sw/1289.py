# swea 1289. 원재의 메모리 복구하기

T = int(input())
for test_case in range(1,T+1):
    lst = list(map(int,list(input())))
    len_lst = len(lst)
    cnt = 0

    flag = True
    for i in range(len_lst):
        if flag:
            if lst[i] == 0:
                continue
            else:
                flag = False
                cnt += 1
        else:
            if lst[i] != 0:
                continue
            else:
                flag = True
                cnt += 1
    print(f"#{test_case} {cnt}")