from functools import cmp_to_key

def compare(a,b):
    len_a = len(a)
    len_b = len(b)
    if len_a > len_b: # 뒤에 오는 것의 이름이 짧으면
        return 1        # 앞으로 오게 바꾸기
    elif len_a < len_b: # 뒤에오는 것의 이름이 길면
        return -1       # 뒤로 오게 바꾸기
    else:
        if a > b:
            return 1
        elif a < b:
            return -1
        else:
            return 0

t = int(input())
for tc in range(1,t+1):
    n = int(input())
    lst = sorted(list(set(input() for _ in range(n))),key = cmp_to_key(compare))  # 중복 제거, 순서 정렬

    print(f'#{tc}')
    for l in lst:
        print(l)