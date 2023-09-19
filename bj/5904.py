# 5904 Moo 게임 -> 재귀
'''
s(1) = s(0) + ( m + o(1+2) ) + s(0)
s(2) = s(1) + ( m + o(2+2) ) + s(1)
'''

def moo(cnt, mid, n):
    pre = (cnt-mid)//2
    if n <= pre:
        return moo(pre, mid-1, n)
    elif n > pre+mid:
        return moo(pre, mid-1, n-pre-mid)
    else:
        if n-pre-1:
            return "o"
        else:
            return "m"

# 입력받기
n = int(input())

cnt, k = 3, 0
while True:
    if n < cnt:
        break
    k += 1
    cnt = cnt*2+k+3

print(moo(cnt, k+3, n))
